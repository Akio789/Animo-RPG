package map;

import characters.*;
import items.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class Window extends JFrame {
    // ATTRIBUTES
    private Cell[][] cells;
    private Hero hero;
    private JPanel topPanel, bottomPanel, mapPanel, equipmentPanel, statsPanel, menuPanel, fightPanel, backpackPanel;
    private JPanel[] equipPanels, backpackPanels;
    private JLabel[] stats;
    private JLabel flaskChargesL;
    private JButton drinkFlaskButton, saveButton, loadButton, exitButton, fightButton, pickUpItemButton;

    // CONSTRUCTOR
    public Window() {
        setSize(650, 700);
        setLayout(new GridLayout(2, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Animo RPG");
    }

    // GETTERS AND SETTERS
    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public JPanel getMapPanel() {
        return mapPanel;
    }

    public void setMapPanel(JPanel mapPanel) {
        this.mapPanel = mapPanel;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public void setTopPanel(JPanel topPanel) {
        this.topPanel = topPanel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(JPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }

    public Window getWindow() {
        return Window.this;
    }

    // METHODS
    public void initComponents() {
        hero = new Yo("Akio", 1, 0, 50, 50, 5, 5, false,
                new HealingFlask("Flask", 5, "This potion heals hp and ether."));
        hero.setHp(10);
        hero.setEther(10);
        hero.setPosX(0);
        hero.setPosX(0);

        // MAIN PANELS
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

        // MENU PANEL
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(new TitledBorder("Menu"));
        drinkFlaskButton = new JButton("Heal");
        drinkFlaskButton.setFont(new Font("Arial", Font.BOLD, 24));
        drinkFlaskButton.addActionListener(new DrinkFlaskButtonListener());
        fightButton = new JButton("Fight");
        fightButton.setFont(new Font("Arial", Font.BOLD, 24));
        fightButton.addActionListener(new FightButtonListener());
        pickUpItemButton = new JButton("Pick up");
        pickUpItemButton.setFont(new Font("Arial", Font.BOLD, 24));
        pickUpItemButton.addActionListener(new PickUpItemButtonListener());
        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 24));
        saveButton.addActionListener(new SaveButtonListener());
        loadButton = new JButton("Load");
        loadButton.setFont(new Font("Arial", Font.BOLD, 24));
        loadButton.addActionListener(new LoadButtonListener());
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 24));
        exitButton.addActionListener(new ExitButtonListener());
        menuPanel.add(drinkFlaskButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(fightButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(pickUpItemButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(saveButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(loadButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(exitButton);
        topPanel.add(menuPanel);

        // MAP PANEL
        cells = new Cell[20][20];
        // Empty cells
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setBackground(Color.lightGray);
            }
        }
        // Cells with Items
        EquipmentItem longSword = new AttackItem("Sword", 7, "A sword crafted for war");
        cells[18][1].setItem(longSword);
        cells[1][3].setItem(longSword);
        cells[8][7].setItem(longSword);
        cells[5][15].setItem(longSword);
        cells[13][17].setItem(longSword);
        // Cells with Enemies
        cells[1][3].setEnemy(new WildMinion(10, 10, 10, 10, false));
        // Cells with Bosses
        cells[2][5].setEnemy(new AntiBestia(10, 10, 10, 10, false));
        cells[17][17].setEnemy(new AntiSuperYo(10, 10, 10, 10, false));
        // Cells that restore
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
                if (cells[i][j].getEnemy() instanceof WildMinion || cells[i][j].getEnemy() instanceof OrderMinion) {
                    cells[i][j].setBackground(Color.red);
                }
            }
        }
        cells[hero.getPosY()][hero.getPosX()].setBackground(Color.blue);
        mapPanel = new JPanel();
        mapPanel.setLayout(new GridLayout(20, 20));
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                mapPanel.add(cells[i][j]);
            }
        }
        topPanel.add(mapPanel);

        // TEST
        hero.addItemToBackpack(1, longSword);
        hero.equipItem(1, longSword);
        hero.unequipItem(1, 1);

        // STATS PANEL
        statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.setBorder(new TitledBorder("Stats"));
        stats = new JLabel[hero.printStats().length];
        for (int i = 0; i < stats.length; i++) {
            stats[i] = new JLabel("  " + hero.printStats()[i]);
            if (i == 0) {
                stats[i].setFont(new Font("Arial", Font.BOLD, 24));

            } else {
                stats[i].setFont(new Font("Arial", Font.BOLD, 22));
            }
            statsPanel.add(stats[i]);
            statsPanel.add(new JLabel(" "));
        }
        topPanel.add(statsPanel);

        // EQUIPMENT PANEL
        equipmentPanel = new JPanel(new GridLayout(4, 1));
        equipmentPanel.setBorder(new TitledBorder("Equipment"));
        equipPanels = new ItemJPanel[4];
        flaskChargesL = new JLabel("Charges: " + hero.getHealingFlask().getCharges());
        equipPanels[0] = new ItemJPanel(hero.getEquipment()[0], flaskChargesL);
        equipmentPanel.add(equipPanels[0]);
        for (int i = 1; i < hero.getEquipment().length; i++) {
            try {
                equipPanels[i] = new ItemJPanel(hero.getEquipment()[i], new JLabel(hero.getEquipment()[i].getName()));
            } catch (NullPointerException e) {
                equipPanels[i] = new ItemJPanel(null, new JLabel("Empty"));
            }
            equipmentPanel.add(equipPanels[i]);
        }
        bottomPanel.add(equipmentPanel);

        // FIGHTS PANEL
        fightPanel = new JPanel();
        fightPanel.setBorder(new TitledBorder("Battle"));
        fightPanel.add(new JLabel("                                                           "));
        bottomPanel.add(fightPanel);

        // BACKPACK PANEL
        backpackPanel = new JPanel(new GridLayout(4, 1));
        backpackPanel.setBorder(new TitledBorder("Backpack"));
        backpackPanels = new ItemJPanel[4];
        for (int i = 0; i < hero.getBackpack().length; i++) {
            try {
                backpackPanels[i] = new ItemJPanel(hero.getBackpack()[i], new JLabel(hero.getBackpack()[i].getName()));
            } catch (NullPointerException e) {
                backpackPanels[i] = new ItemJPanel(null, new JLabel("Empty"));
            }
            backpackPanel.add(backpackPanels[i]);
        }
        bottomPanel.add(backpackPanel);

        // ADD MAIN PANELS TO WINDOW
        add(topPanel);
        add(bottomPanel);
    }

    // ACTION LISTENERS
    public class DrinkFlaskButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                getWindow().getHero().drinkFlask();
                flaskChargesL.setText("Charges: " + getWindow().getHero().getHealingFlask().getCharges());
                for (int i = 1; i < getWindow().getHero().printStats().length; i++) {
                    stats[i].setText("  " + hero.printStats()[i]);
                }
                getWindow().revalidate();
                getWindow().repaint();
            } catch (EmptyFlaskException exception) {
                JOptionPane.showMessageDialog(null, "Flask is empty, it needs to be recharged.", "Empty flask",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    public class LoadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    public class ExitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit game",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public class FightButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class PickUpItemButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
}