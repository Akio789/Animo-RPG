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
    private JPanel topPanel, bottomPanel, mapPanel, equipmentPanel, statsPanel, menuPanel, fightPanel, backpackPanel,
            battleCharactersPanel, battleHeroPanel, battleEnemyPanel, battleAttacksPanel, heroImage, enemyImage;
    private JPanel[] equipPanels, backpackPanels;
    private JLabel[] stats, equipPanelsL, backpackPanelsL;
    private JButton drinkFlaskButton, fightButton, pickUpItemButton, equipItemButton, unEquipItemButton;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem saveMenuItem, loadMenuItem, exitMenuItem;
    private JLabel heroHpL, heroEtherL, enemyHpL, typeOfEnemy;
    private JButton attackB, specialAttackB1, specialAttackB2, escapeB;
    private int turnCounter;

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

    public JLabel getHeroHpL() {
        return heroHpL;
    }

    public void setHeroHpL(JLabel heroHpL) {
        this.heroHpL = heroHpL;
    }

    public JLabel getHeroEtherL() {
        return heroEtherL;
    }

    public void setHeroEtherL(JLabel heroEtherL) {
        this.heroEtherL = heroEtherL;
    }

    public JLabel getEnemyHpL() {
        return enemyHpL;
    }

    public void setEnemyHpL(JLabel enemyHpL) {
        this.enemyHpL = enemyHpL;
    }

    // METHODS
    public void initComponents() {
        hero = new Bestia("Akio", 2, 0, 100, 50, 15, 5, false,
                new HealingFlask("Flask", 5, "This potion heals hp and ether."));
        hero.setHp(95);
        hero.setEther(45);
        hero.setPosX(0);
        hero.setPosX(0);

        // MENU BAR
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        menuBar.add(menu);
        saveMenuItem = new JMenuItem("Save");
        loadMenuItem = new JMenuItem("Load");
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ExitMenuItemListener());
        menu.add(saveMenuItem);
        menu.add(loadMenuItem);
        menu.add(exitMenuItem);

        // MAIN PANELS
        topPanel = new JPanel(new BorderLayout());
        bottomPanel = new JPanel(new BorderLayout());

        // MENU PANEL
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(150, 500));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(new TitledBorder("Actions"));
        drinkFlaskButton = new JButton("Drink flask");
        drinkFlaskButton.setFont(new Font("Arial", Font.BOLD, 20));
        drinkFlaskButton.addActionListener(new DrinkFlaskButtonListener());
        fightButton = new JButton("Fight");
        fightButton.setFont(new Font("Arial", Font.BOLD, 20));
        fightButton.addActionListener(new FightButtonListener());
        pickUpItemButton = new JButton("Pick up");
        pickUpItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        pickUpItemButton.addActionListener(new PickUpItemButtonListener());
        equipItemButton = new JButton("Equip");
        equipItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        equipItemButton.addActionListener(new EquipItemButtonListener());
        unEquipItemButton = new JButton("Unequip");
        unEquipItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        unEquipItemButton.addActionListener(new UnEquipItemButtonListener());
        menuPanel.add(drinkFlaskButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(fightButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(pickUpItemButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(equipItemButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(unEquipItemButton);
        topPanel.add(menuPanel, BorderLayout.WEST);

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
        cells[0][0].setItem(longSword);
        cells[0][0].setEnemy(new WildMinion(100, 10, 10, 10, false));
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
        // cells[hero.getPosY()][hero.getPosX()].setBackground(Color.blue);
        mapPanel = new JPanel();
        mapPanel.setPreferredSize(new Dimension(500, 500));
        mapPanel.setLayout(new GridLayout(20, 20));
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                mapPanel.add(cells[i][j]);
            }
        }
        topPanel.add(mapPanel, BorderLayout.CENTER);

        // STATS PANEL
        statsPanel = new JPanel();
        statsPanel.setPreferredSize(new Dimension(170, 500));
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
        topPanel.add(statsPanel, BorderLayout.EAST);

        // EQUIPMENT PANEL
        equipmentPanel = new JPanel(new GridLayout(4, 1));
        equipmentPanel.setPreferredSize(new Dimension(150, 500));
        equipmentPanel.setBorder(new TitledBorder("Equipment"));
        equipPanels = new ItemJPanel[4];
        equipPanelsL = new JLabel[4];
        equipPanelsL[0] = new JLabel("Charges: " + hero.getHealingFlask().getCharges());
        equipPanels[0] = new ItemJPanel(hero.getHealingFlask(), equipPanelsL[0]);
        equipmentPanel.add(equipPanels[0]);
        for (int i = 0; i < hero.getEquipment().length; i++) {
            try {
                equipPanelsL[i + 1] = new JLabel(hero.getEquipment()[i].getName());
                equipPanels[i + 1] = new ItemJPanel(hero.getEquipment()[i], equipPanelsL[i + 1]);
            } catch (NullPointerException e) {
                equipPanelsL[i + 1] = new JLabel("Empty");
                equipPanels[i + 1] = new ItemJPanel(null, equipPanelsL[i + 1]);
            }
            equipmentPanel.add(equipPanels[i + 1]);
        }
        bottomPanel.add(equipmentPanel, BorderLayout.WEST);

        // FIGHTS PANEL
        fightPanel = new JPanel(new BorderLayout());
        fightPanel.setPreferredSize(new Dimension(500, 500));
        fightPanel.setBorder(new TitledBorder("Battle"));
        battleCharactersPanel = new JPanel(new BorderLayout());
        battleCharactersPanel.setPreferredSize(new Dimension(500, 195));
        battleHeroPanel = new JPanel();
        battleHeroPanel.setLayout(new BoxLayout(battleHeroPanel, BoxLayout.Y_AXIS));
        battleHeroPanel.setPreferredSize(new Dimension(157, 100));
        battleHeroPanel.setBorder(new TitledBorder("Hero"));
        heroHpL = new JLabel(hero.printStats()[3]);
        heroEtherL = new JLabel(hero.printStats()[4]);
        battleHeroPanel.add(heroHpL);
        battleHeroPanel.add(heroEtherL);
        heroImage = new JPanel();
        heroImage.setPreferredSize(new Dimension(30, 30));
        heroImage.setBorder(new TitledBorder("Hero pic"));
        battleHeroPanel.add(heroImage);
        battleEnemyPanel = new JPanel();
        battleEnemyPanel.setLayout(new BoxLayout(battleEnemyPanel, BoxLayout.Y_AXIS));
        battleEnemyPanel.setPreferredSize(new Dimension(157, 100));
        battleEnemyPanel.setBorder(new TitledBorder("Enemy"));
        typeOfEnemy = new JLabel("Minion");
        battleEnemyPanel.add(typeOfEnemy);
        enemyHpL = new JLabel("Hp: ");
        battleEnemyPanel.add(enemyHpL);
        enemyImage = new JPanel();
        enemyImage.setPreferredSize(new Dimension(30, 30));
        enemyImage.setBorder(new TitledBorder("Enemy pic"));
        battleEnemyPanel.add(enemyImage);
        battleCharactersPanel.add(battleHeroPanel, BorderLayout.WEST);
        battleCharactersPanel.add(battleEnemyPanel, BorderLayout.EAST);
        fightPanel.add(battleCharactersPanel, BorderLayout.NORTH);
        battleAttacksPanel = new JPanel(new GridLayout(2, 2));
        battleAttacksPanel.setPreferredSize(new Dimension(100, 100));
        attackB = new JButton("Normal Attack");
        attackB.addActionListener(new NormalAttackListener());
        battleAttacksPanel.add(attackB);
        specialAttackB1 = new JButton("Special Attack1");
        specialAttackB1.addActionListener(new AbilityAttack1Listener());
        battleAttacksPanel.add(specialAttackB1);
        specialAttackB2 = new JButton("Special Attack2");
        specialAttackB2.addActionListener(new AbilityAttack2Listener());
        battleAttacksPanel.add(specialAttackB2);
        escapeB = new JButton("Escape");
        battleAttacksPanel.add(escapeB);
        fightPanel.add(battleAttacksPanel, BorderLayout.SOUTH);
        battleCharactersPanel.setVisible(false);
        battleAttacksPanel.setVisible(false);
        bottomPanel.add(fightPanel, BorderLayout.CENTER);

        // BACKPACK PANEL
        backpackPanel = new JPanel(new GridLayout(4, 1));
        backpackPanel.setPreferredSize(new Dimension(170, 500));
        backpackPanel.setBorder(new TitledBorder("Backpack"));
        backpackPanels = new ItemJPanel[4];
        backpackPanelsL = new JLabel[backpackPanels.length];
        for (

                int i = 0; i < hero.getBackpack().length; i++) {
            try {
                backpackPanelsL[i] = new JLabel(hero.getBackpack()[i].getName());
                backpackPanels[i] = new ItemJPanel(hero.getBackpack()[i], backpackPanelsL[i]);
            } catch (NullPointerException e) {
                backpackPanelsL[i] = new JLabel("Empty");
                backpackPanels[i] = new ItemJPanel(null, backpackPanelsL[i]);
            }
            backpackPanel.add(backpackPanels[i]);
        }
        bottomPanel.add(backpackPanel, BorderLayout.EAST);

        // ADD MAIN PANELS TO WINDOW
        add(topPanel);
        add(bottomPanel);
    }

    // ACTION LISTENERS
    public class DrinkFlaskButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Repainter repainter = new Repainter();
            try {
                getWindow().getHero().drinkFlask();
                equipPanelsL[0].setText("Charges: " + getWindow().getHero().getHealingFlask().getCharges());
                repainter.repaintStats();
                repainter.repaintFightPanel();
            } catch (EmptyFlaskException exception) {
                JOptionPane.showMessageDialog(null, "Flask is empty, it needs to be recharged.", "Empty flask",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public class SaveMenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    public class LoadMenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    public class ExitMenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit game",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public class FightButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (getWindow().getCells()[hero.getPosY()][hero.getPosX()].getEnemy() != null) {
                Repainter repainter = new Repainter();
                battleCharactersPanel.setVisible(true);
                battleAttacksPanel.setVisible(true);
                getWindow().specialAttackB1.setText(hero.getAbilities()[0].getClass().getSimpleName());
                getWindow().specialAttackB2.setText(hero.getAbilities()[1].getClass().getSimpleName());
                repainter.repaintFightPanel();
            } else {
                JOptionPane.showMessageDialog(null, "There's no enemy there.");
            }
        }

    }

    public class NormalAttackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Repainter repainter = new Repainter();
            Enemy enemy = getWindow().getCells()[hero.getPosY()][hero.getPosX()].getEnemy();
            try {
                hero.attackEnemy(enemy);
                repainter.repaintFightPanel();
            } catch (NoDamageException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
            repainter.checkIfEnemyIsDead(enemy);
            repainter.enemyAttack(enemy);
        }
    }

    public class AbilityAttack1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Repainter repainter = new Repainter();
            Enemy enemy = getWindow().getCells()[hero.getPosY()][hero.getPosX()].getEnemy();
            hero.attackEnemyWithAbility(enemy, hero, 0);
            repainter.repaintFightPanel();
            repainter.checkIfEnemyIsDead(enemy);
            repainter.enemyAttack(enemy);
        }
    }

    public class AbilityAttack2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Repainter repainter = new Repainter();
            Enemy enemy = getWindow().getCells()[hero.getPosY()][hero.getPosX()].getEnemy();
            hero.attackEnemyWithAbility(enemy, hero, 1);
            repainter.repaintFightPanel();
            repainter.checkIfEnemyIsDead(enemy);
            repainter.enemyAttack(enemy);
        }
    }

    public class PickUpItemButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int posX = getWindow().getHero().getPosX();
            int posY = getWindow().getHero().getPosY();
            Repainter repainter = new Repainter();
            try {
                if (getWindow().getCells()[posY][posX].getItem() != null) {
                    int backpackIndex = Integer.parseInt(JOptionPane.showInputDialog(null, "Backpack slot: ")) - 1;
                    getWindow().getHero().addItemToBackpack(backpackIndex,
                            getWindow().getCells()[posY][posX].getItem());
                    getWindow().getCells()[posY][posX].setItem(null);
                    repainter.RepaintBackPack();
                    repainter.repaintMap();
                } else {
                    JOptionPane.showMessageDialog(null, "There's no item there.", "Item", JOptionPane.WARNING_MESSAGE);
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                JOptionPane.showMessageDialog(null, "Please enter a valid slot.", "Item", JOptionPane.WARNING_MESSAGE);

            } catch (NumberFormatException exception2) {
                JOptionPane.showMessageDialog(null, "Please enter a number.", "Item", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public class EquipItemButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int backpackIndex = Integer.parseInt(JOptionPane.showInputDialog(null, "Backpack slot: ")) - 1;
                int equipmentIndex = Integer.parseInt(JOptionPane.showInputDialog(null, "Equipment slot: ")) - 2;
                getWindow().getHero().equipItem(equipmentIndex, backpackIndex);
            } catch (SlotFullException exception) {
                JOptionPane.showMessageDialog(null, "Slot is full.", "Equipment", JOptionPane.WARNING_MESSAGE);
            } catch (ArrayIndexOutOfBoundsException exception2) {
                JOptionPane.showMessageDialog(null, "Please enter valid slots.", "Equipment",
                        JOptionPane.WARNING_MESSAGE);
            } catch (NullPointerException exception3) {
                JOptionPane.showMessageDialog(null, "That backpack slot is empty.", "Equipment",
                        JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException exception4) {
                JOptionPane.showMessageDialog(null, "Please enter a number.", "Equipment", JOptionPane.WARNING_MESSAGE);
            }
            Repainter repainter = new Repainter();
            repainter.repaintStats();
            repainter.repaintBackpackAndEquipment();
        }
    }

    public class UnEquipItemButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int equipmentIndex = Integer.parseInt(JOptionPane.showInputDialog(null, "Equipment slot: ")) - 2;
                int backpackIndex = Integer.parseInt(JOptionPane.showInputDialog(null, "Backpack slot: ")) - 1;
                getWindow().getHero().unequipItem(equipmentIndex, backpackIndex);
            } catch (SlotFullException exception) {
                JOptionPane.showMessageDialog(null, "Slot is full.", "Equipment", JOptionPane.WARNING_MESSAGE);
            } catch (ArrayIndexOutOfBoundsException exception2) {
                JOptionPane.showMessageDialog(null, "Please enter valid slots.", "Equipment",
                        JOptionPane.WARNING_MESSAGE);
            } catch (NullPointerException exception3) {
                JOptionPane.showMessageDialog(null, "That equipment slot is empty.", "Equipment",
                        JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException exception4) {
                JOptionPane.showMessageDialog(null, "Please enter a number.", "Equipment", JOptionPane.WARNING_MESSAGE);
            }
            Repainter repainter = new Repainter();
            repainter.repaintStats();
            repainter.repaintBackpackAndEquipment();
        }
    }

    public class Repainter {
        public void repaintStats() {
            for (int i = 1; i < getWindow().getHero().printStats().length; i++) {
                stats[i].setText("  " + hero.printStats()[i]);
            }
            getWindow().revalidate();
            getWindow().repaint();
        }

        public void RepaintBackPack() {
            for (int i = 0; i < backpackPanels.length; i++) {
                try {
                    backpackPanelsL[i].setText(getWindow().getHero().getBackpack()[i].getName());
                } catch (NullPointerException exception) {
                    backpackPanelsL[i].setText("Empty");
                }
            }
            getWindow().revalidate();
            getWindow().repaint();
        }

        public void repaintBackpackAndEquipment() {
            // Repaint equipment
            for (int i = 0; i < getWindow().getHero().getEquipment().length; i++) {
                try {
                    equipPanelsL[i + 1].setText(getWindow().getHero().getEquipment()[i].getName());
                } catch (NullPointerException exception) {
                    equipPanelsL[i + 1].setText("Empty");
                }
            }
            // Repaint backpack
            for (int i = 0; i < backpackPanels.length; i++) {
                try {
                    backpackPanelsL[i].setText(getWindow().getHero().getBackpack()[i].getName());
                } catch (NullPointerException exception) {
                    backpackPanelsL[i].setText("Empty");
                }
            }
            getWindow().revalidate();
            getWindow().repaint();
        }

        public void repaintFightPanel() {
            int posX = getWindow().getHero().getPosX();
            int posY = getWindow().getHero().getPosY();
            if (getWindow().getCells()[posY][posX].getEnemy() != null) {
                heroHpL.setText(hero.printStats()[3]);
                heroEtherL.setText(hero.printStats()[4]);
                typeOfEnemy.setText(getCells()[hero.getPosY()][hero.getPosX()].getEnemy().getClass().getSimpleName());
                enemyHpL.setText("Hp: " + (int) getCells()[hero.getPosY()][hero.getPosX()].getEnemy().getHp());
            }
            getWindow().revalidate();
            getWindow().repaint();
        }

        public void repaintMap() {
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
                    if (cells[i][j].getItem() == null && cells[i][j].getEnemy() == null
                            && cells[i][j].getRestore() == false) {
                        cells[i][j].setBackground(Color.lightGray);

                    }
                }
            }
            // cells[hero.getPosY()][hero.getPosX()].setBackground(Color.blue);
            getWindow().revalidate();
            getWindow().repaint();
        }

        public boolean checkIfHeroIsDead(Hero hero) {
            if ((int) hero.getHp() == 0) {
                JOptionPane.showMessageDialog(null, "YOU DIED!");
                return true;
            } else {
                return false;
            }
        }

        public boolean checkIfEnemyIsDead(Enemy enemy) {
            if ((int) enemy.getHp() == 0) {
                JOptionPane.showMessageDialog(null, "You won the fight!");
                getWindow().getCells()[hero.getPosY()][hero.getPosX()].setEnemy(null);
                battleCharactersPanel.setVisible(false);
                battleAttacksPanel.setVisible(false);
                repaintMap();
                repaintStats();
                return true;
            } else {
                return false;
            }
        }

        public void enemyAttack(Enemy enemy) {
            try {
                enemy.regularAttack(hero);
                repaintFightPanel();
            } catch (NoDamageException exception) {
                JOptionPane.showMessageDialog(null, enemy.getClass().getSimpleName() + " dealed no damage.");
            }
            checkIfHeroIsDead(hero);
        }
    }
}