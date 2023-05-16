import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JFrame;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaihunbek Mohammadullah
 * Date : 8/23/2021
 * This is the frame for the Battle 
 */
public class frmBattle extends javax.swing.JFrame implements ActionListener {
    /*
    Declaring all the necessary ArrayLists and Arrays
    They are used to create Spell objects and an array of SpellObjects
    */
    static ArrayList<Integer> intCardPipsManaList = new ArrayList<Integer>(); 
    static ArrayList<String> strCardNamesList = new ArrayList<String>();
    static ArrayList<Integer> intCardDamageList = new ArrayList<Integer>(); 
    static ArrayList<Spell> spellHandOfCardsList = new ArrayList<Spell>(); 
    static Spell[] spellCardsArr;  
    static Spell[] spellHandOfCardsArr = new Spell[5]; 
    
    // Declaring JButton array for hand of cards 
    static JButton []btnCardArr; 
    
    /*
    Declaring and initializing ImageIcons
    */
    static ImageIcon ninjapigs = new ImageIcon("ninjapigs.jpg");
    static ImageIcon bloodbat = new ImageIcon("bloodbat.jpg"); 
    static ImageIcon thundersnake = new ImageIcon("thundersnake.jpg"); 
    static ImageIcon frostbeetle = new ImageIcon("frostbeetle.jpg");
    static ImageIcon gobbler = new ImageIcon("gobbler.jpg");
    static ImageIcon darksprite = new ImageIcon("darksprite.jpg");
    static ImageIcon orthrus = new ImageIcon("orthrus.jpg"); 
    static ImageIcon imp = new ImageIcon("imp.jpg");
    
    // Declaring crucial variables for the class 
    String strWhichSpell;
    String strUserName; 
    
    // Declaring Wizard objects for Player and Computer
    // Declaring Battle object for game 
    Wizard computer = new Wizard("Computer");
    Wizard player;
    Battle myBattle = new Battle(1);
    
    /**
     * This method reads the text file containing the Spell names and 
     * stores them into the corresponding ArrayList
     */
    public static void readSpellNames(){
        try{
            FileReader fr = new FileReader("SpellNames.txt");
            BufferedReader br = new BufferedReader(fr);
            String strLine = br.readLine();
            while(strLine != null){
                strCardNamesList.add(strLine);
                strLine = br.readLine();
            }
            br.close(); 
        }
        catch(IOException e){}
    }
    
    /**
     * This method reads the text file containing the Spell damages 
     * and stores them into the corresponding ArrayList
     */
    public static void readSpellDamages() {
        try{
            FileReader fr = new FileReader("SpellDamages.txt");
            BufferedReader br = new BufferedReader(fr);
            String strLine = br.readLine();
            while(strLine != null){
                intCardDamageList.add(Integer.parseInt(strLine));
                strLine = br.readLine(); 
            }
            br.close();
        }
        catch(IOException e){}
    }
    
    /**
     * This method reads the Spell pip and mana costs 
     * and stores them into the corresponding array
     */
    public static void readSpellPipsAndMana() {
        try{
            FileReader fr = new FileReader("SpellPipsMana.txt");
            BufferedReader br = new BufferedReader(fr);
            String strLine = br.readLine();
            while(strLine != null){
                intCardPipsManaList.add(Integer.parseInt(strLine));
                strLine = br.readLine(); 
            }
            br.close();
        }
        catch(IOException e){}
    }
    
    /**
     * This method stores spellObjects into an array using the properties gathered in the ArrayLists
     */
    public static void initializeDeckOfCardsArray() {
        spellCardsArr = new Spell[strCardNamesList.size()];
        for (int i = 0; i < spellCardsArr.length; i++){
            Spell spell = new Spell (strCardNamesList.get(i), intCardDamageList.get(i), intCardPipsManaList.get(i));
            spellCardsArr[i] = spell;  
        }
    }
    
    /**
     * 
     * @param min
     * @param max
     * @return random integer between min and max 
     */
    public static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
    
    /**
     * This method initializes an array for the user's hand of cards
     * These are 5 random cards pulled from the array of SpellObjects
     */
    public static void createHandOfCards() {
        for (int i = 0; i < spellHandOfCardsArr.length; i++){
            spellHandOfCardsList.add(spellCardsArr[getRandomNumber(0,8)]); 
            spellHandOfCardsArr[i] = spellHandOfCardsList.get(i);    
        }
    }
    
    /**
     * This method calculates the effects of the spell whose name is written in the parameter 
     * It is used to calculate the lost mana, health, etc
     * @param strSpell 
     */
    public void castSpell(String strSpell) {
        switch (strSpell) {
                case "Thunder Snake": 
                        computer.loseHealth(spellCardsArr[0].getSpellDmg());
                        player.loseMana(spellCardsArr[0].getManaPipCost());
                        player.losePips(spellCardsArr[0].getManaPipCost());
                        if (computer.getHP() < 0) {
                            computer.setHP(0); 
                        }
                        if (player.getMana() < 0){
                            player.setMana(0); 
                        }
                    break;
                case "Ninja Pigs":
                        computer.loseHealth(spellCardsArr[1].getSpellDmg());
                        player.loseMana(spellCardsArr[1].getManaPipCost());
                        player.losePips(spellCardsArr[1].getManaPipCost());;
                        if (computer.getHP() < 0) {
                            computer.setHP(0); 
                        }
                        if (player.getMana() < 0){
                            player.setMana(0); 
                        }
                    break;
                case "Frost Beetle":
                        computer.loseHealth(spellCardsArr[2].getSpellDmg());
                        player.loseMana(spellCardsArr[2].getManaPipCost());
                        player.losePips(spellCardsArr[2].getManaPipCost());
                        if (computer.getHP() < 0) {
                            computer.setHP(0); 
                        }
                        if (player.getMana() < 0){
                            player.setMana(0); 
                        }
                    break;
                case "Gobbler":
                        computer.loseHealth(spellCardsArr[3].getSpellDmg());
                        player.loseMana(spellCardsArr[3].getManaPipCost());
                        player.losePips(spellCardsArr[3].getManaPipCost());
                        if (computer.getHP() < 0) {
                            computer.setHP(0); 
                        }
                        if (player.getMana() < 0){
                            player.setMana(0); 
                        }
                    break; 
                case "Dark Sprite":
                        computer.loseHealth(spellCardsArr[4].getSpellDmg());
                        player.loseMana(spellCardsArr[4].getManaPipCost());
                        player.losePips(spellCardsArr[4].getManaPipCost());
                        if (computer.getHP() < 0) {
                            computer.setHP(0); 
                        }
                        if (player.getMana() < 0){
                            player.setMana(0); 
                        }
                    break;
                case "Orthrus": 
                        computer.loseHealth(spellCardsArr[5].getSpellDmg());
                        player.loseMana(spellCardsArr[5].getManaPipCost());
                        player.losePips(spellCardsArr[5].getManaPipCost());
                        if (computer.getHP() < 0) {
                            computer.setHP(0); 
                        }
                        if (player.getMana() < 0){
                            player.setMana(0); 
                        }
                    break;
                case "Imp":
                        computer.loseHealth(spellCardsArr[6].getSpellDmg());
                        player.loseMana(spellCardsArr[6].getManaPipCost());
                        player.losePips(spellCardsArr[6].getManaPipCost());
                        if (computer.getHP() < 0) {
                            computer.setHP(0); 
                        }
                        if (player.getMana() < 0){
                            player.setMana(0); 
                        }
                    break;
                case "Blood Bat":
                        computer.loseHealth(spellCardsArr[7].getSpellDmg());
                        player.loseMana(spellCardsArr[7].getManaPipCost());
                        player.losePips(spellCardsArr[7].getManaPipCost());
                        if (computer.getHP() < 0) {
                            computer.setHP(0); 
                        }
                        if (player.getMana() < 0){
                            player.setMana(0); 
                        }
                    break;
            }
    }
    

    /**
     * 
     * @param strSpellName
     * @return the index of the Spell in the SpellCardsArr
     */
    public int returnIndexOfSpell(String strSpellName) {
        // Linear search spellcards array to see if user can cast it
        for (int i = 0; i < spellCardsArr.length; i++){
            if (strSpellName.equals(spellCardsArr[i].getSpellName())){
                return i;
            }
        }
        return -1; 
    }
    
    /**
     * 
     * @param intIndex
     * @return true or false, depending on if the user has the resources to cast the Spell at intIndex of Spell array
     */
    public boolean checkIfCanCast(int intIndex){
        if (intIndex == -1){
            return false;
        }
        else {
            return player.getPips() >= spellCardsArr[intIndex].getManaPipCost() && player.getMana() >= spellCardsArr[intIndex].getManaPipCost();
        }   
    }
    
    /**
     * This method generates a random hit for the Computer
     * and calculates its effects on the Player
     */
    public void computerHit(){
         // Program for the computer randomly hitting user:
            //  Computer hits you with random attack ranging from 105-275
            int intRandomNum = getRandomNumber(0, 276); 

        //  Take away mana from computer according to the damage of hit
            if (intRandomNum >= 210){
                player.loseHealth(intRandomNum);
                lblComputerSpellCast.setText("The computer hit you for " + intRandomNum + "!"); 
                if (player.getHP() < 0){
                    player.setHP(0); 
                }
            }
            else if (intRandomNum >=105){
                player.loseHealth(intRandomNum);
                lblComputerSpellCast.setText("The computer hit you for " + intRandomNum + "!");
                if (player.getHP() < 0){
                    player.setHP(0); 
                }

            }
            else {
                lblComputerSpellCast.setText("The computer passed!"); 
            }
    }
    
    /**
     * This method contains the logic which checks if the game has ended 
     * @return "Player's victory" or "Computer's victory" or "Tie"
     */
    public String checkWinner() {
        if (computer.getHP() == 0 && player.getHP() != 0){
            return "Player's victory"; 
        } 
        else if (player.getHP() == 0 && computer.getHP() != 0){
            return "Computer's victory"; 
        }
        else if (player.getMana() == 0 && computer.getHP() != 0){
            return "Computer's Victory"; 
        }
        else if (player.getHP() == 0 && computer.getHP() == 0){
            return "Tie"; 
        }
        else if (player.getMana() == 0 && computer.getHP() == 0){
            return "Tie";
        }
        else {
            return "Ongoing"; 
        }
    }
    
    /**
     * This method makes the program wait, or go to sleep, for the amount of seconds put into parameter 
     * @param sec 
     */
    public void wait(int sec) {
	 try {
		 Thread.currentThread().sleep(sec * 1000);
	 } catch (InterruptedException e) {
		 e.printStackTrace();
	 }
    }
    
    /**
     * This method waits three seconds and then clears the text on the GUI
     */
    public void clearText(){
        wait(3); 
        lblSpellCast.setText("Select a card then click Next Round to cast it"); 
        lblComputerSpellCast.setText("");
    }
    
    /**
     * This method fully clears the GUI, used at the end of the game 
     */
    public void clearGUI() {
        for (int i = 0; i < 5; i++){
                remove(btnCardArr[i]);
            }
            remove(lblRoundNum); 
            remove(btnPass); 
            remove(btnNextRound); 
            remove(lblUserName); 
            remove(lblUserHP);
            remove(lblUserHPNum);
            remove(lblUserPips); 
            remove(lblUserPipsNum); 
            remove(lblUserMana); 
            remove(lblUserManaNum);
            remove(lblComputer);
            remove(lblComputerHP); 
            remove(lblComputerHPNum); 
            remove(lblWelcome); 
    }

    
    
    /**
     * Creates new form frmBattle
     * @param strNameOfPlayer
     */
    public frmBattle(String strNameOfPlayer) {  
        // Saving player's username for later use
        strUserName = strNameOfPlayer; 
        initComponents();
       
        // making object of player 
        this.player = new Wizard(strNameOfPlayer);
        
        // Set the username label to name inputted previously
        lblUserName.setText(player.getName()); 
        
        // reading the text files containing the spellcard info
      
        readSpellNames();
        readSpellDamages();
        readSpellPipsAndMana(); 
        
        // then make arrays full of Spell objects
        
        initializeDeckOfCardsArray(); // big array which has all cards 
        createHandOfCards(); // randomized array containing 5 random cards for player 
        
        // Informing player to Select a card and then click Next Round 
        lblSpellCast.setText("Select a card then click Next Round to cast it"); 
        
        // Laying out the hand of cards onto GUI  
        btnCardArr = new JButton[5]; // JButton array
        int intX = 125; // The x coordinate 
        
        /*
        The next block of code does many things: 
        It will make the JButtons appear on the GUI
        It will assign to each JButton the corresponding image 
        It will program what will happen when each button is pressed 
        */
        for (int i = 0; i < btnCardArr.length; i++){
            // btnCardArr[i] being assigned its spell name 
            btnCardArr[i] = new JButton(spellHandOfCardsArr[i].getSpellName());
            
            // assign image to button according to name of button 
            switch (btnCardArr[i].getText()) {
                case "Thunder Snake": 
                    btnCardArr[i].setIcon(thundersnake); 
                    break;
                case "Ninja Pigs":
                    btnCardArr[i].setIcon(ninjapigs);
                    break;
                case "Frost Beetle":
                    btnCardArr[i].setIcon(frostbeetle);
                    break;
                case "Gobbler":
                    btnCardArr[i].setIcon(gobbler);
                    break; 
                case "Dark Sprite":
                    btnCardArr[i].setIcon(darksprite);
                    break;
                case "Orthrus": 
                    btnCardArr[i].setIcon(orthrus);
                    break;
                case "Imp":
                    btnCardArr[i].setIcon(imp);
                    break;
                case "Blood Bat":
                    btnCardArr[i].setIcon(bloodbat);
                    break;
            }
            
            // making the JButton array appear on GUI 
            btnCardArr[i].setSize(127, 195); 
            btnCardArr[i].setLocation(intX, 100);
            
            
            btnCardArr[i].addActionListener((ActionEvent e) -> {
                /*
                When each button is pressed, the String will change value 
                to the spell which the button is showing 
                */
                if (e.getSource() == btnCardArr[0]){
                   strWhichSpell = btnCardArr[0].getText(); 
                }
                else if (e.getSource() == btnCardArr[1]){
                    strWhichSpell = btnCardArr[1].getText(); 
                }
                else if (e.getSource() == btnCardArr[2]){
                    strWhichSpell = btnCardArr[2].getText(); 
                }
                else if (e.getSource() == btnCardArr[3]){
                    strWhichSpell = btnCardArr[3].getText(); 
                }
                else if (e.getSource() == btnCardArr[4]){
                    strWhichSpell = btnCardArr[4].getText(); 
                }
                else if (e.getSource() == btnCardArr[5]){
                    strWhichSpell = btnCardArr[5].getText(); 
                }
                else if (e.getSource() == btnCardArr[6]){
                    strWhichSpell = btnCardArr[6].getText(); 
                }
                else if (e.getSource() == btnCardArr[7]){
                    strWhichSpell = btnCardArr[7].getText(); 
                }
            });
            add(btnCardArr[i]); 
            intX += 135;
        }    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblUserHP = new javax.swing.JLabel();
        lblUserPips = new javax.swing.JLabel();
        lblUserMana = new javax.swing.JLabel();
        btnNextRound = new javax.swing.JButton();
        lblUserManaNum = new javax.swing.JLabel();
        lblUserHPNum = new javax.swing.JLabel();
        lblComputer = new javax.swing.JLabel();
        lblComputerHP = new javax.swing.JLabel();
        lblComputerHPNum = new javax.swing.JLabel();
        lblUserPipsNum = new javax.swing.JLabel();
        lblRoundNum = new javax.swing.JLabel();
        lblSpellCast = new javax.swing.JLabel();
        btnPass = new javax.swing.JButton();
        lblComputerSpellCast = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setFont(new java.awt.Font("Tahoma", 3, 28)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 0, 153));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Battle!");

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        lblUserHP.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUserHP.setForeground(new java.awt.Color(255, 0, 0));
        lblUserHP.setText("HP:");

        lblUserPips.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUserPips.setForeground(new java.awt.Color(255, 0, 255));
        lblUserPips.setText("Pips:");

        lblUserMana.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUserMana.setForeground(new java.awt.Color(0, 0, 255));
        lblUserMana.setText("Mana:");

        btnNextRound.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNextRound.setText("Next Round");
        btnNextRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextRoundActionPerformed(evt);
            }
        });

        lblUserManaNum.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUserManaNum.setForeground(new java.awt.Color(0, 0, 255));
        lblUserManaNum.setText("20");

        lblUserHPNum.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUserHPNum.setForeground(new java.awt.Color(255, 0, 0));
        lblUserHPNum.setText("1000");

        lblComputer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblComputer.setForeground(new java.awt.Color(0, 102, 102));
        lblComputer.setText("Computer");

        lblComputerHP.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblComputerHP.setForeground(new java.awt.Color(255, 0, 0));
        lblComputerHP.setText("HP:");

        lblComputerHPNum.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblComputerHPNum.setForeground(new java.awt.Color(255, 0, 0));
        lblComputerHPNum.setText("1000");

        lblUserPipsNum.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUserPipsNum.setForeground(new java.awt.Color(204, 0, 204));
        lblUserPipsNum.setText("1");

        lblRoundNum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRoundNum.setText("Round # 1");

        lblSpellCast.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSpellCast.setForeground(new java.awt.Color(102, 0, 0));
        lblSpellCast.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnPass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPass.setText("Pass");
        btnPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassActionPerformed(evt);
            }
        });

        lblComputerSpellCast.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblComputerSpellCast.setForeground(new java.awt.Color(0, 102, 102));
        lblComputerSpellCast.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblComputerSpellCast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblWelcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoundNum, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblUserHP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblUserHPNum)
                                        .addGap(10, 10, 10)
                                        .addComponent(lblUserPips)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblUserPipsNum)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblUserMana)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblUserManaNum))
                                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblComputerHP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblComputerHPNum, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblComputer))))
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNextRound)
                        .addContainerGap())
                    .addComponent(lblSpellCast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSpellCast, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(lblRoundNum)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPass)
                            .addComponent(btnNextRound))
                        .addGap(149, 149, 149)
                        .addComponent(lblComputerSpellCast, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblComputer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserHP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserHPNum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserPips, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserPipsNum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserMana, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserManaNum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComputerHP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComputerHPNum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextRoundActionPerformed
        // TODO add your handling code here:
        
        // if no button has been pressed then:
        if (strWhichSpell == null){
            strWhichSpell = ""; 
            }
        
         /*
        Check if the user has passed this round 
        */ 
            // if he has:
        if (strWhichSpell.equals("Pass")){
        
            computerHit(); // generate and calculate a random hit by the computer
            
            // Update the lbl to indicate the User has passed
            lblSpellCast.setText("You passed this round!");
            // reset the String for next time
            strWhichSpell = "";
             
                
        //  add to round counter 
            myBattle.addRound();  

        //  update user and computer pips 
            player.addPips(); 
            computer.addPips(); 

        //  Update user stats 
        
            lblUserHPNum.setText(String.valueOf(player.getHP())); 
            lblUserManaNum.setText(String.valueOf(player.getMana()));
            lblUserPipsNum.setText(String.valueOf(player.getPips()));
            
        //  Update computer stats 
        
            lblComputerHPNum.setText(String.valueOf(computer.getHP()));
            super.update(this.getGraphics());
            lblRoundNum.setText("Round # " + String.valueOf(myBattle.getRound()));
            
            clearText(); // clear text on the gui 
        }
        
        /*
        Check if chosen spell is castable by the player
        */ 
            // if it is: 
        else if (checkIfCanCast(returnIndexOfSpell(strWhichSpell))){
            
            computerHit(); // generate and calculate random hit by computer 
            
        //  calculate the effects of the spell that was chosen 
            castSpell(strWhichSpell);
       
        //  output the casted spell
            lblSpellCast.setText(spellCardsArr[returnIndexOfSpell(strWhichSpell)].toString());
            strWhichSpell = ""; // reset strWhichSpell for the next time 
            
        //  add to round counter 
            myBattle.addRound(); 


        //  update user and computer pips 
        
            player.addPips(); 
            computer.addPips(); 

        //  Update user stats 
        
            lblUserHPNum.setText(String.valueOf(player.getHP())); 
            lblUserManaNum.setText(String.valueOf(player.getMana()));
            lblUserPipsNum.setText(String.valueOf(player.getPips()));
            
        //  Update computer stats 
        
            lblComputerHPNum.setText(String.valueOf(computer.getHP()));
            super.update(this.getGraphics());
            lblRoundNum.setText("Round # " + String.valueOf(myBattle.getRound()));
            
            clearText(); // clearText on the gui 
        } 
        
        /*
        if the user has not clicked a card yet:
        */
            else if (strWhichSpell.equals("")){
                lblSpellCast.setText("Select a card first, then press Next Round."); 
            }
            
            // if the spell chosen by user is not castable: 
            else {
                // inform the user that they cannot cast it 
                lblSpellCast.setText("Not enough resources to cast that. Pass or cast another spell."); 
                strWhichSpell = ""; // reset the String 
                super.update(this.getGraphics()); 
            }
        /*
        Every round check if the game has ended 
        */
        if (!checkWinner().equals("Ongoing")){
            
           /*
            Make the label large and in the centre
            Say that the game is over 
            */
            lblSpellCast.setLocation(0, 198);
            lblSpellCast.setFont(new Font("Tahoma", Font.BOLD, 45));
            lblSpellCast.setText("The battle is over!");
           
            clearGUI(); // remove all the unnecessary GUI
            
            super.update(this.getGraphics());
        }
        
        /*
        Check if the game is over
        If the game is over, then go to next frame 
        */
        if (!checkWinner().equals("Ongoing")){
            wait(3); // wait 3 seconds 
            frmGameOver myGame = new frmGameOver(checkWinner(), strUserName); 
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true); 
            this.dispose();
            
        }
       
        
          
    }//GEN-LAST:event_btnNextRoundActionPerformed

    private void btnPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassActionPerformed
        // TODO add your handling code here:
        strWhichSpell = "Pass"; // when btnPass is pressed, the String will store "Pass" 
    }//GEN-LAST:event_btnPassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBattle("").setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNextRound;
    private javax.swing.JButton btnPass;
    private javax.swing.JLabel lblComputer;
    private javax.swing.JLabel lblComputerHP;
    private javax.swing.JLabel lblComputerHPNum;
    private javax.swing.JLabel lblComputerSpellCast;
    private javax.swing.JLabel lblRoundNum;
    private javax.swing.JLabel lblSpellCast;
    private javax.swing.JLabel lblUserHP;
    private javax.swing.JLabel lblUserHPNum;
    private javax.swing.JLabel lblUserMana;
    private javax.swing.JLabel lblUserManaNum;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserPips;
    private javax.swing.JLabel lblUserPipsNum;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
