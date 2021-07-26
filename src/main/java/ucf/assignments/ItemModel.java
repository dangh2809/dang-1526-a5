package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemModel {

    private ObservableList<Item> itemList = FXCollections.observableArrayList();

    public ObservableList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ObservableList<Item> itemList) {
        this.itemList = itemList;
    }
    public void addItem(String serialNumber, String itemName, double itemPrice){
        itemList.add(new Item(serialNumber, itemName, itemPrice));
    }
    public void editItem(int index, Item item){
        itemList.set(index, item);
    }
    public void deleteItem(Item item){
        itemList.remove(item);
    }
}
