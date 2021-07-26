package ucf.assignments;

import javafx.css.converter.StringConverter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.awt.event.ActionEvent;
import java.io.IOException;
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

        inventoryItemTableView.setEditable(true);
        itemSerialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        itemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        valueItemColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

    }
    public void changeSerialNumberCellEvent(TableColumn.CellEditEvent editedCell){
        Item itemSelected = inventoryItemTableView.getSelectionModel().getSelectedItem();
        itemSelected.setSerialNumber((String) editedCell.getNewValue());
    }
    public void changeItemNameCellEvent(TableColumn.CellEditEvent editedCell){
        Item itemSelected = inventoryItemTableView.getSelectionModel().getSelectedItem();
        itemSelected.setName((String) editedCell.getNewValue());
    }
    public void changeItemPriceCellEvent(TableColumn.CellEditEvent editedCell){
        Item itemSelected = inventoryItemTableView.getSelectionModel().getSelectedItem();
        itemSelected.setPrice((Double) editedCell.getNewValue());
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
        itemModel.deleteItem(inventoryItemTableView.getSelectionModel().getSelectedItem());
    }

}
