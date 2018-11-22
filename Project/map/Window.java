package map;

import characters.*;
import items.*;
import javax.swing.*;
import javax.swing.border.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class Window extends JFrame implements KeyListener, Serializable {
    // ATTRIBUTES
    private Cell[][] cells;
    private Hero hero;
    private JPanel wrapper, topPanel, bottomPanel, mapPanel, equipmentPanel, statsPanel, menuPanel, fightPanel,
            backpackPanel, battleCharactersPanel, battleHeroPanel, battleEnemyPanel, battleAttacksPanel, heroImage,
            enemyImage, fightInfoP;
    private JPanel[] equipPanels, backpackPanels;
    private JLabel[] stats;
    private JButton drinkFlaskButton, fightButton, pickUpItemButton, equipItemButton, unEquipItemButton, restoreButton;
    private JButton[] equipPanelsB, backpackPanelsB;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem saveMenuItem, loadMenuItem, exitMenuItem;
    private JLabel heroHpL, heroEtherL, enemyHpL, typeOfEnemy, turnL, heroDmgL, enemyDmgL;
    private JButton attackB, specialAttackB1, specialAttackB2, escapeB;
    private int turn, turnsFrozen;
    private int itemInfo;

    // CONSTRUCTOR
    public Window() {
        setSize(650, 730);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Uncanny Valley");
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
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

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    // METHODS
    public void initComponents() {
        hero = new Bestia("Akio", 2, 0, 1000, 50, 25, 5, false,
                new HealingFlask("Flask", 5, "This potion heals hp and ether."));
        hero.setHp(600);
        hero.setEther(45);
        hero.setPosX(8);
        hero.setPosY(19);

        // MENU BAR
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        menu.setFocusable(false);
        menuBar.add(menu);
        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setFocusable(false);
        saveMenuItem.addActionListener(new SaveMenuItemListener());
        loadMenuItem = new JMenuItem("Load");
        loadMenuItem.setFocusable(false);
        loadMenuItem.addActionListener(new LoadMenuItemListener());
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setFocusable(false);
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
        drinkFlaskButton.setFocusable(false);
        drinkFlaskButton.addActionListener(new DrinkFlaskButtonListener());
        fightButton = new JButton("Fight");
        fightButton.setFont(new Font("Arial", Font.BOLD, 20));
        fightButton.setFocusable(false);
        fightButton.addActionListener(new FightButtonListener());
        pickUpItemButton = new JButton("Pick up");
        pickUpItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        pickUpItemButton.setFocusable(false);
        pickUpItemButton.addActionListener(new PickUpItemButtonListener());
        equipItemButton = new JButton("Equip");
        equipItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        equipItemButton.setFocusable(false);
        equipItemButton.addActionListener(new EquipItemButtonListener());
        unEquipItemButton = new JButton("Unequip");
        unEquipItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        unEquipItemButton.setFocusable(false);
        unEquipItemButton.addActionListener(new UnEquipItemButtonListener());
        restoreButton = new JButton("Touch river");
        restoreButton.setFont(new Font("Arial", Font.BOLD, 20));
        restoreButton.setFocusable(false);
        restoreButton.addActionListener(new RestoreButtonListener());
        menuPanel.add(drinkFlaskButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(fightButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(pickUpItemButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(equipItemButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(unEquipItemButton);
        menuPanel.add(new JLabel(" "));
        menuPanel.add(restoreButton);
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
        EquipmentItem motherStone = new DefenseItem("Mother Stone", 7,
                "It's pink, it feels warm, like home... home, a mother, I didn't even remember having one.");
        EquipmentItem deathStone = new AttackItem("Death", 23,
                "I am cursed now, I feel a uncontrollable rage, I remember pain and anger, I killed a man, and I didn't feel a thing."); // Designed
                                                                                                                                         // to
                                                                                                                                         // work
                                                                                                                                         // with
                                                                                                                                         // solitude
        EquipmentItem solitudeStone = new DefenseItem("Solitude", 35,
                "As I touched this artifact I got absorbed by a spiral of sadness, I remembered the lowest points of my life and they generated a profund rage."); // Complements
                                                                                                                                                                   // death
        EquipmentItem reasonStone = new DefenseItem("Counter-Logic", 12,
                "I finally find peace, but not for long, quickly I get sorrounded by thoughts, questions, but most of it can be answered by just analising my envoriment, I find peace again, I like it, and I remember, I remember my work, my world, my name... this is not real."); // Last
                                                                                                                                                                                                                                                                                       // stone,
                                                                                                                                                                                                                                                                                       // final
                                                                                                                                                                                                                                                                                       // piece
                                                                                                                                                                                                                                                                                       // of
                                                                                                                                                                                                                                                                                       // the
                                                                                                                                                                                                                                                                                       // puzzle
        EquipmentItem animalStone = new AttackItem("Instinct", 10,
                "I feel empty, I have hunger, but not just for eat, hunger for everything, I need a gal, I need to eat, I need to fight, I need violence, I need to scape, NO, I like it in here, here I can have it all."); // Drive
                                                                                                                                                                                                                             // Theory
        cells[18][1].setItem(deathStone);
        cells[1][3].setItem(animalStone);
        cells[8][7].setItem(motherStone);
        cells[5][15].setItem(solitudeStone);
        cells[13][17].setItem(reasonStone);
        // Cells with Enemies
        // WildMinions
        cells[0][1].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[1][1].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[5][0].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[9][0].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[16][0].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[0][5].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[0][11].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[2][8].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[4][5].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[5][8].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[6][7].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[7][3].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[7][5].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[9][0].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[11][2].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[13][4].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[16][0].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[17][2].setEnemy(new WildMinion(85, 200, 9, 2, false));
        cells[18][2].setEnemy(new WildMinion(85, 200, 9, 2, false));
        // StrongWildMinions
        cells[1][0].setEnemy(new StrongWildMinion(250, 200, 45, 1, false));
        cells[2][4].setEnemy(new StrongWildMinion(250, 200, 45, 1, false));
        cells[2][6].setEnemy(new StrongWildMinion(250, 200, 45, 1, false));
        cells[2][10].setEnemy(new StrongWildMinion(250, 200, 45, 1, false));
        cells[6][1].setEnemy(new StrongWildMinion(250, 200, 45, 1, false));
        cells[9][3].setEnemy(new StrongWildMinion(250, 200, 45, 1, false));
        cells[14][2].setEnemy(new StrongWildMinion(250, 200, 45, 1, false));
        cells[16][1].setEnemy(new StrongWildMinion(250, 200, 45, 1, false));
        cells[19][2].setEnemy(new StrongWildMinion(250, 200, 45, 1, false));
        // OrderMinions
        cells[1][18].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[2][18].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[4][18].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[4][14].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[6][18].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[6][16].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[7][18].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[8][13].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[10][15].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[10][14].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[10][12].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[11][19].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[11][12].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[12][19].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[12][16].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[12][12].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[13][16].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[13][15].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[13][14].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[13][11].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[13][10].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[14][14].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[14][10].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[15][10].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[16][8].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[16][7].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[17][19].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[17][12].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[17][11].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[17][10].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        cells[17][9].setEnemy(new OrderMinion(110, 200, 5, 3, false));
        // StrongOrderMinions
        cells[0][18].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[3][18].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[4][16].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[5][18].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[6][14].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[8][18].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[8][16].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[8][17].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[8][14].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[9][16].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[10][16].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[10][13].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[11][18].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[12][17].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[13][12].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[14][19].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[14][18].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[15][14].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[15][15].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[16][9].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[16][18].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[17][18].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[17][15].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[17][13].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[18][18].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[18][17].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[18][15].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        cells[19][15].setEnemy(new StrongOrderMinion(400, 200, 50, 6, false));
        // Cells with Bosses
        cells[2][5].setEnemy(new AntiBestia(100, 10, 10, 10, false));
        cells[17][17].setEnemy(new AntiSuperYo(100, 10, 10, 10, false));
        /*
         * //Este codigo es para poner el antiYo donde sea que vaya dependiendo de la
         * eleccion de personaje del jugador, si el jugador elige razon, el antiyo irá
         * en la posición en la que iría este y lo mismo para el ello
         * cells[2][5].setEnemy(new AntiYo(100, 10, 10, 10, false));
         * cells[17][17].setEnemy(new AntiYo(100, 10, 10, 10, false));
         */
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
                    cells[i][j].setBackground(Color.cyan);
                }
                if (cells[i][j].getItem() != null) {
                    cells[i][j].setBackground(Color.yellow);
                }
                if (cells[i][j].getEnemy() instanceof Boss) {
                    cells[i][j].setBackground(Color.black);
                }
                if (cells[i][j].getEnemy() instanceof WildMinion) {
                    cells[i][j].setBackground(Color.red);
                }
                if (cells[i][j].getEnemy() instanceof StrongWildMinion) {
                    cells[i][j].setBackground(Color.orange);
                }
                if (cells[i][j].getEnemy() instanceof OrderMinion) {
                    cells[i][j].setBackground(Color.gray);
                }
                if (cells[i][j].getEnemy() instanceof StrongOrderMinion) {
                    cells[i][j].setBackground(Color.white);
                }
            }
        }
        cells[hero.getPosY()][hero.getPosX()].setBackground(Color.blue);
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
            if (i == 0) {
                stats[i] = new JLabel(" " + hero.getClass().getSimpleName() + " " + hero.printStats()[i]);
                stats[i].setFont(new Font("Arial", Font.BOLD, 24));
            } else {
                stats[i] = new JLabel("  " + hero.printStats()[i]);
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
        equipPanelsB = new JButton[4];
        equipPanelsB[0] = new JButton("Charges: " + (hero.getHealingFlask().getCharges() + ""));
        equipPanelsB[0].setFocusable(false);
        equipPanels[0] = new ItemJPanel(hero.getHealingFlask(), equipPanelsB[0]);
        equipPanelsB[0].setActionCommand("4");
        // equipPanelsB[0].setIcon(new ImageIcon("images/trump.png"));
        equipPanelsB[0].addActionListener(new EquipmentReadDescriptionListener());
        equipmentPanel.add(equipPanels[0]);
        for (int i = 0; i < hero.getEquipment().length; i++) {
            try {
                equipPanelsB[i + 1] = new JButton(hero.getEquipment()[i].getName());
                equipPanelsB[i + 1].setFocusable(false);
                equipPanels[i + 1] = new ItemJPanel(hero.getEquipment()[i], equipPanelsB[i + 1]);
                equipPanelsB[i + 1].setActionCommand(((i + 4) + 1) + "");
                equipPanelsB[i + 1].addActionListener(new EquipmentReadDescriptionListener());
            } catch (NullPointerException e) {
                equipPanelsB[i + 1] = new JButton("Empty");
                equipPanelsB[i + 1].setFocusable(false);
                equipPanelsB[i + 1].setActionCommand(((i + 4) + 1) + "");
                equipPanels[i + 1] = new ItemJPanel(null, equipPanelsB[i + 1]);
                equipPanelsB[i + 1].addActionListener(new EquipmentReadDescriptionListener());

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
        attackB.setFocusable(false);
        attackB.addActionListener(new NormalAttackListener());
        battleAttacksPanel.add(attackB);
        specialAttackB1 = new JButton("Special Attack1");
        specialAttackB1.setFocusable(false);
        specialAttackB1.addActionListener(new AbilityAttack1Listener());
        battleAttacksPanel.add(specialAttackB1);
        specialAttackB2 = new JButton("Special Attack2");
        specialAttackB2.setFocusable(false);
        specialAttackB2.addActionListener(new AbilityAttack2Listener());
        battleAttacksPanel.add(specialAttackB2);
        escapeB = new JButton("Escape");
        escapeB.setFocusable(false);
        escapeB.addActionListener(new EscapeBattleListener());
        battleAttacksPanel.add(escapeB);
        fightPanel.add(battleAttacksPanel, BorderLayout.CENTER);
        fightInfoP = new JPanel();
        fightInfoP.setLayout(new BoxLayout(fightInfoP, BoxLayout.Y_AXIS));
        turnL = new JLabel("Turn: ");
        fightInfoP.add(turnL);
        heroDmgL = new JLabel();
        fightInfoP.add(heroDmgL);
        enemyDmgL = new JLabel();
        fightInfoP.add(enemyDmgL);
        fightInfoP.setPreferredSize(new Dimension(100, 75));
        fightPanel.add(fightInfoP, BorderLayout.SOUTH);
        battleCharactersPanel.setVisible(false);
        battleAttacksPanel.setVisible(false);
        fightInfoP.setVisible(false);
        bottomPanel.add(fightPanel, BorderLayout.CENTER);

        // BACKPACK PANEL
        backpackPanel = new JPanel(new GridLayout(4, 1));
        backpackPanel.setPreferredSize(new Dimension(170, 500));
        backpackPanel.setBorder(new TitledBorder("Backpack"));
        backpackPanels = new ItemJPanel[4];
        backpackPanelsB = new JButton[backpackPanels.length];
        for (int i = 0; i < hero.getBackpack().length; i++) {
            try {
                backpackPanelsB[i] = new JButton(hero.getBackpack()[i].getName());
                backpackPanelsB[i].setFocusable(false);
                backpackPanels[i] = new ItemJPanel(hero.getBackpack()[i], backpackPanelsB[i]);
                backpackPanelsB[i].setActionCommand(i + "");
                backpackPanelsB[i].addActionListener(new BackpackReadDescriptionListener());
            } catch (NullPointerException e) {
                backpackPanelsB[i] = new JButton("Empty");
                backpackPanelsB[i].setActionCommand(i + "");
                backpackPanelsB[i].setFocusable(false);
                backpackPanels[i] = new ItemJPanel(null, backpackPanelsB[i]);
                backpackPanelsB[i].addActionListener(new BackpackReadDescriptionListener());
            }
            backpackPanel.add(backpackPanels[i]);
        }
        bottomPanel.add(backpackPanel, BorderLayout.EAST);

        // ADD MAIN PANELS TO WRAPPER
        wrapper = new JPanel();
        wrapper.setLayout(new GridLayout(2, 1));

        wrapper.add(topPanel);
        wrapper.add(bottomPanel);
        add(wrapper);
    }

    // ACTION LISTENERS
    public class DrinkFlaskButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Repainter repainter = new Repainter();
            try {
                getWindow().getHero().drinkFlask();
                equipPanelsB[0].setText("Charges: " + getWindow().getHero().getHealingFlask().getCharges());
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
            try {
                FileOutputStream fos1 = new FileOutputStream("hero.animo");
                ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
                oos1.writeObject(hero);
                oos1.close();
                FileOutputStream fos2 = new FileOutputStream("map.animo");
                ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
                oos2.writeObject(cells);
                oos2.close();
                JOptionPane.showMessageDialog(null, "Game saved.");
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, "Couldn't save.");
            }
        }
    }

    public class LoadMenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Repainter repainter = new Repainter();
                File file1 = new File("hero.animo");
                FileInputStream fin1 = new FileInputStream(file1);
                ObjectInputStream ois1 = new ObjectInputStream(fin1);
                hero = (Hero) ois1.readObject();
                File file2 = new File("map.animo");
                FileInputStream fin2 = new FileInputStream(file2);
                ObjectInputStream ois2 = new ObjectInputStream(fin2);
                cells = (Cell[][]) ois2.readObject();
                mapPanel.removeAll();
                for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells[i].length; j++) {
                        mapPanel.add(cells[i][j]);
                    }
                }
                repainter.repaintStats();
                repainter.repaintBackpackAndEquipment();
                repainter.RepaintBackPack();
                repainter.repaintMap();
                JOptionPane.showMessageDialog(null, "Game loaded.");
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, "Couldn't load.");
            } catch (ClassNotFoundException exception2) {
                exception2.printStackTrace();
            }
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
            turn = 1;
            if (getWindow().getCells()[hero.getPosY()][hero.getPosX()].getEnemy() != null) {
                Repainter repainter = new Repainter();
                battleCharactersPanel.setVisible(true);
                battleAttacksPanel.setVisible(true);
                fightInfoP.setVisible(true);
                turnL.setText("Turn " + turn);
                heroDmgL.setText("");
                enemyDmgL.setText("");
                getWindow().specialAttackB1.setText(hero.getAbilities()[0].getClass().getSimpleName());
                getWindow().specialAttackB2.setText(hero.getAbilities()[1].getClass().getSimpleName());
                repainter.repaintFightPanel();
                setFocusable(false);
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
                int enemyHpBefore = (int) enemy.getHp();
                hero.attackEnemy(enemy);
                int enemyHpAfter = (int) enemy.getHp();
                heroDmgL.setText("You dealed " + (enemyHpBefore - enemyHpAfter) + " damage.");
                repainter.repaintFightPanel();
            } catch (NoDamageException exception) {
                heroDmgL.setText("You dealed no damage.");
            }
            turn++;
            if (!repainter.checkIfEnemyIsDead(enemy)) {
                repainter.enemyAttack(enemy);
            }
        }
    }

    public class AbilityAttack1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = 0;
            Repainter repainter = new Repainter();
            Enemy enemy = getWindow().getCells()[hero.getPosY()][hero.getPosX()].getEnemy();
            try {
                if (hero instanceof Bestia) {
                    int enemyHpBefore = (int) enemy.getHp();
                    hero.attackEnemyWithAbility(enemy, hero, index);
                    int enemyHpAfter = (int) enemy.getHp();
                    heroDmgL.setText("You dealed " + (enemyHpBefore - enemyHpAfter) + " damage.");
                } else if (hero instanceof Yo) {
                    hero.attackEnemyWithAbility(enemy, hero, index);
                    int enemyDefAfter = (int) enemy.getDefense();
                    heroDmgL.setText("Enemy's defense was reduced to " + enemyDefAfter + ".");
                } else if (hero instanceof SuperYo) {
                    hero.attackEnemyWithAbility(enemy, hero, index);
                    int enemyDefAfter = (int) enemy.getDefense();
                    int enemyAtkAfter = (int) enemy.getAttack();
                    heroDmgL.setText("Enemy's defense was reduced to " + enemyDefAfter + " and attack to "
                            + enemyAtkAfter + ".");
                }
            } catch (NotEnoughEtherException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
            turn++;
            repainter.repaintFightPanel();
            if (!repainter.checkIfEnemyIsDead(enemy)) {
                repainter.enemyAttack(enemy);
            }
        }
    }

    public class AbilityAttack2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = 1;
            Repainter repainter = new Repainter();
            Enemy enemy = getWindow().getCells()[hero.getPosY()][hero.getPosX()].getEnemy();
            try {
                if (hero instanceof Bestia) {
                    int enemyHpBefore = (int) enemy.getHp();
                    hero.attackEnemyWithAbility(enemy, hero, index);
                    int enemyHpAfter = (int) enemy.getHp();
                    heroDmgL.setText("You dealed " + (enemyHpBefore - enemyHpAfter) + " damage.");
                } else if (hero instanceof Yo) {
                    hero.attackEnemyWithAbility(enemy, hero, index);
                    int enemyDefAfter = (int) enemy.getDefense();
                    heroDmgL.setText("Enemy's defense was reduced to " + enemyDefAfter + ".");
                } else if (hero instanceof SuperYo) {
                    hero.attackEnemyWithAbility(enemy, hero, index);
                    turnsFrozen = 3;
                }
            } catch (NotEnoughEtherException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
            turn++;
            repainter.repaintFightPanel();
            if (!repainter.checkIfEnemyIsDead(enemy)) {
                repainter.enemyAttack(enemy);
            }
        }
    }

    public class EscapeBattleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double rand = Math.random();
            Repainter repainter = new Repainter();
            Enemy enemy = getWindow().getCells()[hero.getPosY()][hero.getPosX()].getEnemy();
            if (rand > 0.70) {
                JOptionPane.showMessageDialog(null, "You escaped!");
                setFocusable(true);
                battleAttacksPanel.setVisible(false);
                battleCharactersPanel.setVisible(false);
                fightInfoP.setVisible(false);
                repainter.repaintStats();
            } else {
                JOptionPane.showMessageDialog(null, "You couldn't escape!");
                repainter.enemyAttack(enemy);
                heroDmgL.setText(" ");
            }
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

    public class RestoreButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Repainter repainter = new Repainter();
            try {
                getWindow().getCells()[hero.getPosY()][hero.getPosX()].restore(hero, getWindow());
                JOptionPane.showMessageDialog(null, "All your stats and your flask are restored");
                repainter.repaintStats();
                repainter.repaintBackpackAndEquipment();
                repainter.repaintStats();
            } catch (NoRiverException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }
    }

    public class BackpackReadDescriptionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            itemInfo = Integer.parseInt(e.getActionCommand());
            if (hero.getBackpack()[itemInfo] != null) {
                JOptionPane.showMessageDialog(null, hero.getBackpack()[itemInfo].getDescription(),
                        hero.getBackpack()[itemInfo].getName() + " description", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public class EquipmentReadDescriptionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            itemInfo = Integer.parseInt(e.getActionCommand());
            if (itemInfo == 4) {
                JOptionPane.showMessageDialog(null, hero.getHealingFlask().getDescription(),
                        "Healing Flask description", JOptionPane.INFORMATION_MESSAGE);
            } else if (hero.getEquipment()[itemInfo - 5] != null) {
                JOptionPane.showMessageDialog(null, hero.getEquipment()[itemInfo - 5].getDescription(),
                        hero.getEquipment()[itemInfo - 5].getName() + " description", JOptionPane.INFORMATION_MESSAGE);
            }
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
                    backpackPanelsB[i].setText(getWindow().getHero().getBackpack()[i].getName());
                } catch (NullPointerException exception) {
                    backpackPanelsB[i].setText("Empty");
                }
            }
            getWindow().revalidate();
            getWindow().repaint();
        }

        public void repaintBackpackAndEquipment() {
            // Repaint equipment
            equipPanelsB[0].setText("Charges: " + getHero().getHealingFlask().getCharges());
            for (int i = 0; i < getWindow().getHero().getEquipment().length; i++) {
                try {
                    equipPanelsB[i + 1].setText(getWindow().getHero().getEquipment()[i].getName());
                } catch (NullPointerException exception) {
                    equipPanelsB[i + 1].setText("Empty");
                }
            }
            // Repaint backpack
            for (int i = 0; i < backpackPanels.length; i++) {
                try {
                    backpackPanelsB[i].setText(getWindow().getHero().getBackpack()[i].getName());
                } catch (NullPointerException exception) {
                    backpackPanelsB[i].setText("Empty");
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
                turnL.setText("Turn: " + turn);
            }
            getWindow().revalidate();
            getWindow().repaint();
        }

        public void repaintMap() {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    if (cells[i][j].getRestore() == true) {
                        cells[i][j].setBackground(Color.cyan);
                    }
                    if (cells[i][j].getItem() != null) {
                        cells[i][j].setBackground(Color.yellow);
                    }
                    if (cells[i][j].getEnemy() instanceof Boss) {
                        cells[i][j].setBackground(Color.black);
                    }
                    if (cells[i][j].getEnemy() instanceof WildMinion) {
                        cells[i][j].setBackground(Color.red);
                    }
                    if (cells[i][j].getEnemy() instanceof StrongWildMinion) {
                        cells[i][j].setBackground(Color.orange);
                    }
                    if (cells[i][j].getEnemy() instanceof OrderMinion) {
                        cells[i][j].setBackground(Color.gray);
                    }
                    if (cells[i][j].getEnemy() instanceof StrongOrderMinion) {
                        cells[i][j].setBackground(Color.white);
                    }
                    if (cells[i][j].getEnemy() == null && cells[i][j].getItem() == null
                            && cells[i][j].getRestore() == false) {
                        cells[i][j].setBackground(Color.lightGray);
                    }
                }
            }
            cells[hero.getPosY()][hero.getPosX()].setBackground(Color.blue);
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
            if ((int) enemy.getHp() <= 0) {
                JOptionPane.showMessageDialog(null, "You won the fight!");
                getWindow().getCells()[hero.getPosY()][hero.getPosX()].setEnemy(null);
                battleCharactersPanel.setVisible(false);
                battleAttacksPanel.setVisible(false);
                fightInfoP.setVisible(false);
                repaintMap();
                repaintStats();
                setFocusable(true);
                return true;
            } else {
                return false;
            }
        }

        public void enemyAttack(Enemy enemy) {
            if (!enemy.getStatusParalysis()) {
                try {
                    int heroHpBefore = (int) hero.getHp();
                    enemy.attack(hero);
                    int heroHpAfter = (int) hero.getHp();
                    enemyDmgL.setText(
                            enemy.getClass().getSimpleName() + " dealed " + (heroHpBefore - heroHpAfter) + " damage.");
                    repaintFightPanel();
                    checkIfHeroIsDead(hero);
                } catch (NoDamageException exception) {
                    enemyDmgL.setText(enemy.getClass().getSimpleName() + " dealed no damage.");
                }
            } else {
                turnsFrozen--;
                enemyDmgL.setText("Enemy is restrained for " + turnsFrozen + " turns, it can't attack.");
                if (turnsFrozen == 1) {
                    enemy.setStatusParalysis(false);
                }
            }
        }
    }

    public void keyTyped(KeyEvent e) {

        try {
            Repainter repainter = new Repainter();
            if (e.getKeyChar() == 'w') {

                hero.setPosY(hero.getPosY() - 1);
                hero.getPosX();
                cells[hero.getPosY()][hero.getPosX()].setBackground(Color.blue);
                repainter.repaintMap();
            }
            if (e.getKeyChar() == 's') {
                revalidate();
                hero.setPosY(hero.getPosY() + 1);
                hero.getPosX();
                cells[hero.getPosY()][hero.getPosX()].setBackground(Color.blue);
                repainter.repaintMap();
            }
            if (e.getKeyChar() == 'a') {
                hero.setPosX(hero.getPosX() - 1);
                hero.getPosY();
                cells[hero.getPosY()][hero.getPosX()].setBackground(Color.blue);
                repainter.repaintMap();
            }
            if (e.getKeyChar() == 'd') {
                hero.setPosX(hero.getPosX() + 1);
                hero.getPosY();
                cells[hero.getPosY()][hero.getPosX()].setBackground(Color.blue);
                repainter.repaintMap();
            }
        } // fin try
        catch (ArrayIndexOutOfBoundsException array) {
            if (e.getKeyChar() == 'w') {
                hero.setPosY(hero.getPosY() + 1);
                hero.getPosX();
            } // fin if w
            if (e.getKeyChar() == 's') {
                hero.setPosY(hero.getPosY() - 1);
                hero.getPosX();
            } // fin if s
            if (e.getKeyChar() == 'a') {
                hero.getPosY();
                hero.setPosX(hero.getPosX() + 1);
            } // fin if a
            if (e.getKeyChar() == 'd') {
                hero.getPosY();
                hero.setPosX(hero.getPosX() - 1);
            } // fin if d

        }

    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

}