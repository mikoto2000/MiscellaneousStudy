%{
// wordParser : ただ一つの単語をパースするパーサ。
// 受け取った文字列がただ一つの単語でない場合はすべてパースエラーとなる。
// 単語の切れ目は、 golang の scanner.Scanner クラスのデフォルトの挙動に依存する(深く考えてない)。
package main

import (
    "github.com/k0kubun/pp"
    "os"
    "text/scanner"
    "strings"
)

type Result interface {}

%}

%union{
    word string
}

// %union に列挙したフィールドと、「%xxx<yyy> の yyy」が対応しているようだ。
// つまり、ここでは word ルールの成果物(?)と、
// WORD トークンの成果物(?)はともに string であるということを宣言している？
%type<word> word
%token<word> WORD

%%

word
    : WORD {
        pp.Println($1)
    }

%%

// yyLexer インタフェースを実装したオブジェクトを作成する。
// こいつの Lex メソッドが、字句解析を担当する。
type Lexer struct {
    scanner.Scanner
}


// Lex : トークンを一つ読み進める。
// この実装では、スキャンした結果を何でもかんでも WORD として解釈する。
func (l *Lexer) Lex(lval *yySymType) int {
    token := int(l.Scan())

    // EOF 以外はすべて WORD
    if token != scanner.EOF {
        // WORD は、yacc 宣言部で書いた token<xxx> のどれか
        token = WORD
    }

    // 解析結果を lval に詰める。
    // この実装では、 WORD が string 型なので、実際の文字列を格納している。
    lval.word = l.TokenText()

    // 解釈したトークンの種類を返却する
    return token
}

/* エラーはとりあえずパニック */
func (l *Lexer) Error(e string) {
    panic(e)
}


func main() {
    // 自作 Lexer 作成
    l := new(Lexer)

    // 第一引数をパースするように設定
    l.Init(strings.NewReader(os.Args[1]))

    // パース実行
    yyParse(l)
}
