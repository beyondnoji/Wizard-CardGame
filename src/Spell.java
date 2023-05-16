/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaihunbek Mohammadullah
 * Date : 8/23/2021
 * This is the class for Spellcards
 */
public class Spell {
    int intDMG, intManaPipsCost; // properties of spellcards  
    String strSpellName; // properties of spellcards 
    
    
    /**
     * Constructor
     * Creates a Spell object and initializes its properties
     * @param SpellName
     * @param SpellDmg
     * @param Pips 
     */
    public Spell(String SpellName, int SpellDmg, int Pips){
        strSpellName = SpellName; 
        intDMG = SpellDmg; 
        intManaPipsCost = Pips; 
    }
    
    /**
     * 
     * @return the damage of a Spell
     */
    public int getSpellDmg() {
        return this.intDMG; 
    }
    
    /**
     * 
     * @return the Mana and Pip cost of a Spell 
     */
    public int getManaPipCost(){
        return this.intManaPipsCost; 
    }
    
    /**
     * 
     * @return the name of a Spell 
     */
    public String getSpellName() {
        return this.strSpellName; 
    }
    

    /**
     * 
     * @return a String which showcases the Spell's effects
     */
    @Override
    public String toString() {
        String strOutput;  
        strOutput = "You have casted " + this.getSpellName() + "!"; 
        strOutput += " Hitting the enemy for " + this.getSpellDmg() + " damage!"; 
        return strOutput; 
    }
    
    
    
}
