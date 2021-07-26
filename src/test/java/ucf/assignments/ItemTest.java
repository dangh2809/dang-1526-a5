package ucf.assignments;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getName() {
        Item item = new Item("123","apple",4.8);
        String expected = "apple";
        String actual = item.getName();
        assertEquals(expected,actual);

    }

    @Test
    void nameProperty() {
        Item item = new Item("123","apple",4.8);
        String expected = "apple";
        SimpleStringProperty actualName = item.nameProperty();
        String actual = actualName.getValue();
        assertEquals(expected,actual);

    }

    @Test
    void setName() {
        Item item = new Item("","",2);
        item.setName("apple");
        String expected = "apple";
        String actual = item.getName();
        assertEquals(expected,actual);
    }

    @Test
    void getSerialNumber() {
        Item item = new Item("123","apple",4.8);
        String expected  = "123";
        String actual  = item.getSerialNumber();
        assertEquals(expected,actual);
    }

    @Test
    void serialNumberProperty() {
        Item item = new Item("123","apple",4.8);
        String expected = "123";
        SimpleStringProperty actualSerialNumber = item.serialNumberProperty();
        String actual = actualSerialNumber.getValue();
        assertEquals(expected,actual);
    }

    @Test
    void setSerialNumber() {
        Item item = new Item("","",2);
        item.setSerialNumber("123");
        String expected = "123";
        String actual = item.getSerialNumber();
        assertEquals(expected,actual);
    }

    @Test
    void getPrice() {
        Item item = new Item("","",2);
        double expected = 2;
        double actual = item.getPrice();
        assertEquals(expected,actual);
    }

    @Test
    void priceProperty() {
        Item item = new Item("123","apple",4.8);
        double expected = 4.8;
        SimpleDoubleProperty actualPrice = item.priceProperty();
        double actual = actualPrice.getValue();
        assertEquals(expected,actual);
    }

    @Test
    void setPrice() {
        Item item = new Item("","",2);
        item.setPrice(2);
        double expected = 2;
        double actual = item.getPrice();
        assertEquals(expected,actual);
    }
}