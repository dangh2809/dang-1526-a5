package ucf.assignments;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;


public class MainWindowController implements Initializable
{
    @FXML
    private TableView<Item> inventoryItemTableView;

    @FXML
    private TableColumn<Item, String> itemSerialNumberColumn;

    @FXML
    private TableColumn<Item, String> itemNameColumn;

    @FXML
    private TableColumn<Item, Double> valueItemColumn;

    @FXML
    private TextField itemSerialNumber;

    @FXML
    private TextField itemName;

    @FXML
    private TextField itemPrice;
    private ItemModel itemModel;

    private SceneManager sceneManager;


    public MainWindowController(ItemModel itemModel, SceneManager sceneManager){
        this.itemModel = itemModel;
        this.sceneManager = sceneManager;

    }
    public void initialize(URL url, ResourceBundle rb){
        //set up the column in the table view
        itemSerialNumberColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("serialNumber"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        valueItemColumn.setCellValueFactory(new PropertyValueFactory<Item,Double>("price"));
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        valueItemColumn.setCellFactory(tc->new TableCell<Item,Double>(){
            @Override
            protected void updateItem(Double price, boolean empty){
                super.updateItem(price,empty);
                if(empty){
                    setText(null);
                } else{
                    setText(currencyFormat.format(price));
                }
            }
        });
        //load data
        inventoryItemTableView.setItems(itemModel.getItemList());
    }
    @FXML
    void AddItemButtonClicked(javafx.event.ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Add New Item");
        stage.setScene(sceneManager.getScene("AddItemWindow"));
        stage.show();
        AddItemWindowController add = new AddItemWindowController(itemModel, sceneManager);
    }

    @FXML
    void DeleteItemButtonClicked(javafx.event.ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Edit Item");
        stage.setScene(sceneManager.getScene("EditItemWindow"));
        stage.show();
    }
}
