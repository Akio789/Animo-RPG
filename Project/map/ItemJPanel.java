package map;

import characters.*;
import items.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class ItemJPanel extends JPanel implements Serializable {
    private Item item;
    private JButton itemName;

    public ItemJPanel(Item item, JButton itemName) {
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

    public JButton getItemName() {
        return itemName;
    }

    public void setItemName(JButton itemName) {
        this.itemName = itemName;
    }
}