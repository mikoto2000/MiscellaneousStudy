package jp.dip.oyasirazu.study.javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeViewUseFxmlController implements Initializable {
    @FXML TreeView<String> treeView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // ルートの子要素を作成
        TreeItem<String> item1 = new TreeItem<String>("Item 1");
        TreeItem<String> item2 = new TreeItem<String>("Item 2");
        TreeItem<String> item3 = new TreeItem<String>("Item 3");
        TreeItem<String> item4 = new TreeItem<String>("Item 4");

        // item4 の子要素
        TreeItem<String> item41 = new TreeItem<String>("Item 4-1");
        TreeItem<String> item42 = new TreeItem<String>("Item 4-2");
        TreeItem<String> item43 = new TreeItem<String>("Item 4-3");

        // item4 に子要素を追加する
        ObservableList<TreeItem<String>> image4tChildren =
                item4.getChildren();
        image4tChildren.add(item41);
        image4tChildren.add(item42);
        image4tChildren.add(item43);

        TreeItem<String> root = new TreeItem<String>("root");
        treeView.setRoot(root);

        // ルート要素に子要素を追加する
        ObservableList<TreeItem<String>> rootChildren =
                root.getChildren();
        rootChildren.add(item1);
        rootChildren.add(item2);
        rootChildren.add(item3);
        rootChildren.add(item4);

        // 子を持つノードを開く
        root.setExpanded(true);
        item4.setExpanded(true);
    }
}

