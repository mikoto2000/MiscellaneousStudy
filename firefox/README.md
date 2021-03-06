firefox
=======

Firefox の WebExtensions についての勉強記録。


試し方
------

1. Firefox のアドレスバーに `about:debugging` と入力し、Firefox 開発ツールデバッガーを開く。
2. 右上の、 `一時的なアドオンを読み込む` ボタンを押す
3. 試したい WebExtension の `manifest.json` を選択する

これで、Firefox 開発ツールデバッガーの一覧の、「一時的な拡張機能」に、選択した WebExtension が追加される。


挙動
----

| 名前               | 挙動 |
|:-------------------|:-----|
| FirstWebExtensions | 開いたページの body 要素に赤太枠をつける
| Copy               | `c` キーを押すと開いているページの URL がクリップボードにコピーされる
| BrowserAction      | `BrowserAction` ボタンを押下すると、アドオンのデバッグコンソールに `testing` と出力される([アドオンのデバッグコンソールについて](#アドオンのデバッグコンソールについて)も参照してください)


アドオンのデバッグコンソールについて
------------------------------------

background script 内の `console.log()` は、開発者ツールのコンソールには表示されない。
次の手順で開く、アドオンのデバッグコンソールに表示される。

1. Firefox のアドレスバーに `about:debugging` と入力し、Firefox 開発者ツールデバッガーを表示
2. 「アドオンのデバッグを有効化」にチェックを入れる
3. デバッグしたいアドオンの「デバッグ」ボタンを押す
4. リモートデバッグ接続要求ダイアログが表示されるので、 OK ボタンを押す

WebExtensions 内で実行した `console.log()` は、この手順で開いたコンソールに出力される。


content script は、ページの開発者ツールのコンソールに表示される。
