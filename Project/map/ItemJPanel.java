package map;

import characters.*;
import items.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class ItemJPanel extends JPanel {
    private Item item;
    private JLabel itemName;

    public ItemJPanel(Item item, JLabel itemName) {
        this.item = item;
        this.itemName = itemName;
        this.add(itemName);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public JLabel getItemName() {
        return itemName;
    }

    public void setItemName(JLabel itemName) {
        this.itemName = itemName;
    }
}