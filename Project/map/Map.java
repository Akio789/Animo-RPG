package map;

import characters.*;
import items.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class Map extends JFrame{
    private Cell[][] cells;
    private JPanel mapPanel;
    
    public Map(){
        setSize(500,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }
    
    public void initComponents() {
        cells = new Cell[20][20];
        
        //Empty cells
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setBackground(Color.lightGray);
            }   
        }
        
        //Cells with Items
        cells[18][1].setItem(new AttackItem("Long Sword", 7, "A sword crafted for war"));
        cells[1][3].setItem(new AttackItem("Long Sword", 7, "A sword crafted for war"));
        cells[8][7].setItem(new AttackItem("Long Sword", 7, "A sword crafted for war"));
        cells[5][15].setItem(new AttackItem("Long Sword", 7, "A sword crafted for war"));
        cells[13][17].setItem(new AttackItem("Long Sword", 7, "A sword crafted for war"));
    
        //Cells with Enemies
        cells[1][3].setEnemy(new WildMinion(1, 10, 10, 10, 10, false));
        
        //Cells with Bosses
        cells[2][5].setEnemy(new AntiBestia(1, 10, 10, 10, 10, false));
        cells[17][17].setEnemy(new AntiSuperYo(1, 10, 10, 10, 10, false));

        //Cells that restore
        cells[19][4].setRestore(true);
        cells[19][5].setRestore(true);
        cells[18][4].setRestore(true);
        cells[18][5].setRestore(true);
        cells[17][5].setRestore(true);
        cells[17][6].setRestore(true);
        cells[16][5].setRestore(true);
        cells[16][6].setRestore(true);
        cells[15][5].setRestore(true);
        cells[15][6].setRestore(true);
        cells[14][6].setRestore(true);
        cells[14][7].setRestore(true);
        cells[13][6].setRestore(true);
        cells[13][7].setRestore(true);
        cells[12][6].setRestore(true);
        cells[12][7].setRestore(true);
        cells[11][7].setRestore(true);
        cells[11][8].setRestore(true);
        cells[11][9].setRestore(true);
        cells[10][7].setRestore(true);
        cells[10][8].setRestore(true);
        cells[10][9].setRestore(true);
        cells[9][9].setRestore(true);
        cells[9][10].setRestore(true);
        cells[9][11].setRestore(true);
        cells[8][9].setRestore(true);
        cells[8][10].setRestore(true);
        cells[8][11].setRestore(true);
        cells[7][10].setRestore(true);
        cells[7][11].setRestore(true);
        cells[6][10].setRestore(true);
        cells[6][11].setRestore(true);
        cells[5][11].setRestore(true);
        cells[5][12].setRestore(true);
        cells[4][11].setRestore(true);
        cells[4][12].setRestore(true);
        cells[3][12].setRestore(true);
        cells[3][13].setRestore(true);
        cells[3][14].setRestore(true);
        cells[3][15].setRestore(true);
        cells[2][12].setRestore(true);
        cells[2][13].setRestore(true);
        cells[2][14].setRestore(true);
        cells[2][15].setRestore(true);
        cells[1][14].setRestore(true);
        cells[1][15].setRestore(true);
        cells[0][14].setRestore(true);
        cells[0][15].setRestore(true);
        cells[0][16].setRestore(true);
        
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getRestore() == true) {
                    cells[i][j].setBackground(Color.green);
                }
                if (cells[i][j].getItem() != null) {
                    cells[i][j].setBackground(Color.yellow);
                }
                if (cells[i][j].getEnemy() instanceof Boss) {
                    cells[i][j].setBackground(Color.black);
                }
                if (cells[i][j].getEnemy() instanceof WildMinion ||
                cells[i][j].getEnemy() instanceof OrderMinion) {
                    cells[i][j].setBackground(Color.red);
                }
            }
        }
        
        mapPanel = new JPanel(new GridLayout(20,20));
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                mapPanel.add(cells[i][j]);
            }
        }
        add(mapPanel);
    }
}