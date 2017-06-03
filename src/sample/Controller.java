package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {



    @FXML
    public void showAdd(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
            stage.setTitle("add feeds");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void showDel(ActionEvent actionEvent) {

    }

    public void loadTreeView(String... rootItems){
        TreeItem<String> root = new TreeItem<String>("Root Node");
        root.setExpanded(true);
        for (String itemStrings: rootItems){
            root.getChildren().add(new TreeItem<String>(itemStrings));
        }

        treeView.setRoot(root);
    }

    @FXML
    private TreeView<String> treeView;

    public void loadTreeView1(){

        testTableCollection tableCollection = new testTableCollection();

        testTable tableTest1 = new testTable();
        tableTest1.setFeedsTitle("Folder1");
        tableTest1.setFeedTitle("Feed");


        testTable tableTest2 = new testTable();
        tableTest1.setFeedsTitle("Folder1");
        tableTest1.setFeedTitle("Feed");

        tableCollection.add(tableTest1);
        tableCollection.add(tableTest2);

        TreeItem<String> rootNode = new TreeItem<String>("RssFeeeed");
        rootNode.setExpanded(true);

        for (testTable tests : tableCollection.getTestsList()) {
            TreeItem<String> feedsTitle = new TreeItem<String>(tests.getFeedsTitle());
            boolean found = false;
            for (TreeItem<String> node : rootNode.getChildren()) {
                if(node.getValue().contentEquals(tests.getFeedTitle())){
                    node.getChildren().add(feedsTitle);
                    found = true;
                    break;
                }
            }
            if (!found){
                TreeItem<String> node = new TreeItem<String>(tests.getFeedTitle());
                rootNode.getChildren().add(node);
                node.getChildren().add(feedsTitle);
            }

        }
//        TreeView<String> treeView = new TreeView<String>(rootNode);
    }

    public void initialize(){
        loadTreeView("init 1", "init 2", "init 3");
//        loadTreeView1();
    }


}
