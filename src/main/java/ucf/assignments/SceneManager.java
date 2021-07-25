package ucf.assignments;

import com.sun.tools.javac.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private Map<String, Scene> scenes = new HashMap<>();
    public void load(){
        ItemModel itemModel = new ItemModel();
        MainWindowController mainWindowController = new MainWindowController(itemModel, this);
        AddItemWindowController addItemWindowController = new AddItemWindowController(itemModel, this);
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        loader.setController(mainWindowController);
        try{
            root = loader.load();
            scenes.put("MainWindow",new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader = new FXMLLoader(getClass().getResource("AddItemWindow.fxml"));
        loader.setController(addItemWindowController);
        try{
            root = loader.load();
            scenes.put("AddItemWindow",new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Scene getScene(String name){
        return scenes.get(name);
    }
}
