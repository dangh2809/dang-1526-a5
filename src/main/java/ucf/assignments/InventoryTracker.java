package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InventoryTracker extends Application {

    @Override

    public void start(Stage primaryStage) {
        try{
            SceneManager sceneMenu = new SceneManager();
            sceneMenu.load();

            Scene scene = sceneMenu.getScene("MainWindow");
            primaryStage.setTitle("Inventory Tracker");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
