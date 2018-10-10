package map;

import characters.*;
import items.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Map extends JFrame{
    private JLabel[][] cells;
    private JPanel mapPanel;
    
    public Map(){
        setSize(500,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }
    
    public void initComponents() {
        cells = new Cell[5][5];
        
        //Empty cells
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setText("o");
            }   
        }
        
        //Cells with Items
        Item longSword = new AttackItem("Long Sword", 7, "A sword crafted for war");
        cells[0][1] = new Cell(longSword);
        cells[0][1].setText("i");
        
        //Cells with Enemies
        Enemy cyclops = new WildMinion(1, 10, 10, 10, 10, false);
        cells[1][3] = new Cell(cyclops);
        cells[1][3].setText("e");
        
        //Cells with Bosses
        Enemy dragon = new AntiBestia(1, 10, 10, 10, 10, false);
        cells[4][4] = new Cell(dragon);
        cells[4][4].setText("b");
        
        //Cells that restore
        cells[2][2] = new Cell(true);
        cells[2][2].setText("r");
        
        mapPanel = new JPanel(new GridLayout(5,5));
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                mapPanel.add(cells[i][j]);
            }
        }
        add(mapPanel);
    }
}