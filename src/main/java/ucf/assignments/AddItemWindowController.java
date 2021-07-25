package ucf.assignments;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class AddItemWindowController {
    private ItemModel itemModel;
    private SceneManager sceneManager;

    public AddItemWindowController(ItemModel itemModel, SceneManager sceneManager){
        this.itemModel = itemModel;
        this.sceneManager = sceneManager;
    }
    @FXML
    private TextField serialNumberTextField;

    @FXML
    private TextField itemNameTextField;

    @FXML
    private TextField itemPriceTextField;

    @FXML
    void AddItemWindowButtonClicked(ActionEvent event) {

        String serialNumberAdd = serialNumberTextField.getText();
        String itemNameAdd = itemNameTextField.getText();

        boolean validInput = true;

        if(serialNumberAdd.length()<1){
            serialNumberTextField.setPromptText("Serial Number must be 1 character or more");
            serialNumberTextField.clear();

            validInput = false;
        }
        if(itemNameAdd.length()<1){
            itemNameTextField.setPromptText("Item description must be 1 character or more");
            itemNameTextField.clear();

            validInput = false;
        }
        try {
            double itemPriceAdd = Double.parseDouble(itemPriceTextField.getText());
            if(validInput) {
                itemModel.addItem(serialNumberAdd, itemNameAdd, itemPriceAdd);

                //clear info for add window
                serialNumberTextField.setPromptText("Serial Number");
                serialNumberTextField.clear();

                itemNameTextField.setPromptText("Item's name");
                itemNameTextField.clear();

                itemPriceTextField.setPromptText("Price");
                itemPriceTextField.clear();

                Stage stage = (Stage) itemNameTextField.getScene().getWindow();
                stage.close();
            }
        } catch(NumberFormatException e){

            itemPriceTextField.setPromptText("Price is required and must be a number");
            itemPriceTextField.clear();
            validInput = false;
        }

    }

}
