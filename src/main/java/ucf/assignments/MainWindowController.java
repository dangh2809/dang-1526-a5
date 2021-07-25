package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import javax.swing.text.TableView;
import java.awt.event.ActionEvent;

public class MainWindowController
{
    @FXML
    private TableView inventoryItemTableView;

    @FXML
    private TableColumn<?, ?> itemSerialNumberColumn;

    @FXML
    private TableColumn<?, ?> itemNameColumn;

    @FXML
    private TableColumn<?, ?> valueItemColumn;

    @FXML
    private TextField itemSerialNumber;

    @FXML
    private TextField itemName;

    @FXML
    private TextField itemPrice;

    @FXML
    void AddItemButtonClicked(ActionEvent event) {
        String sn = itemSerialNumber.getText();
        String name = itemName.getText();
    }

    @FXML
    void DeleteItemButtonClicked(ActionEvent event) {

    }
}
