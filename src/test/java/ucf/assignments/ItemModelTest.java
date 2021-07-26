package ucf.assignments;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemModelTest {
    @Test
    void getItemList() {
        ItemModel list = new ItemModel();
        ObservableList<Item> itemList  = FXCollections.observableArrayList();
        Item item = new Item("123","apple",4.8);
        itemList.add(item);
        list.setItemList(itemList);
        Item expected  = item;
        Item actual = list.getItemList().get(0);
        assertEquals(expected,actual);

    }
    @Test
    void setItemList() {
        ItemModel list = new ItemModel();
        ObservableList<Item> itemList  = FXCollections.observableArrayList();
        Item item = new Item("123","apple",4.8);
        itemList.add(item);
        list.setItemList(itemList);
        Item expected  = item;
        Item actual = list.getItemList().get(0);
        assertEquals(expected,actual);

    }

    @Test
    void addItem() {
        ItemModel list = new ItemModel();
        Item item = new Item("123","apple",4.8);
        ObservableList<Item> expected = (ObservableList<Item>) item;
        list.setItemList((ObservableList<Item>) item);
        expected.add( new Item("234","chocolate",2));

        list.addItem("234","Chocolate",2);
        ObservableList<Item> actual = list.getItemList();

        assertEquals(expected,actual);
    }


    @Test
    void deleteItem() {
        ItemModel list = new ItemModel();
        ObservableList<Item> itemList  = FXCollections.observableArrayList();
        Item item1 = new Item("123","apple",4.8);

        Item item2 = new Item("345","orange",2);
        itemList.add(item1);
        ObservableList<Item> expected = itemList;



        list.getItemList().add(item1);
        list.getItemList().add(item2);

        list.deleteItem(item2);
        ObservableList<Item> actual = list.getItemList();

        assertEquals(expected,actual);
    }
}