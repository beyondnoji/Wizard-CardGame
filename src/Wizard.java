/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaihunbek Mohammadullah
 * Date : 8/23/2021
 * This is the class for Wizards (both Player and Computer) 
 */
public class Wizard {
    
    int intHP, intMana, intPips; // properties of Wizard class
    String strName; // properties of Wizard class
    
    /**
     * Constructor
     * @param Name
     * Creates object and initializes properties 
     */
    public Wizard (String Name) {
        strName = Name; 
        intHP = 1000; 
        intMana = 20; 
        intPips = 1; 
    }
    
    /**
     * Subtracts x amount of health from Wizard
     * @param intHPDeduction 
     */
    public void loseHealth(int intHPDeduction) {
        intHP = intHP - intHPDeduction; 
    }
    
    /**
     * Subtracts x amount of mana from Wizard
     * @param intManaDeduction 
     */
    public void loseMana(int intManaDeduction){
        intMana = intMana - intManaDeduction;
    }
    
    /**
     * Adds one pip to wizard's pip count
     */
    public void addPips(){
        intPips += 1; 
    }
    
    /**
     * Subtracts x amount of pips from Wizard
     * @param intPipCost 
     */
    public void losePips(int intPipCost){
        intPips = intPips - intPipCost; 
    }
    
    /**
     * 
     * @return the name of the Wizard, i.e., the player's username
     */
    public String getName() {
        return this.strName; 
    }
    
    /**
     * 
     * @return the amount of pips that the Wizard has
     */
    public int getPips() {
        return this.intPips; 
    }
    
    /**
     * 
     * @return the amount of mana that the Wizard has  
     */
    public int getMana() {
        return this.intMana; 
    }
    
    /**
     * 
     * @return the health of the Wizard  
     */
    public int getHP() {
        return this.intHP; 
    }
    
    /**
     * Sets the health of Wizard to intNum
     * @param intNum 
     */
    public void setHP(int intNum) {
        intHP = intNum; 
    }
    
    /**
     * Sets the mana of Wizard to intNum
     * @param intNum 
     */
    public void setMana(int intNum) {
        intMana = intNum; 
    }
    
    
}
