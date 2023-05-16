/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaihunbek Mohammadullah
 * Date : 8/23/2021
 * This is the class for the Battle
 */
public class Battle {
    int intCurrentRound; // propery of Battle
    
    /**
     * Constructor
     * Creates Battle object, and initializes it properties 
     * @param intRound 
     */
    public Battle(int intRound) {
        intCurrentRound = intRound; 
    }
    
    /**
     * adds 1 to the current road of Battle 
     */
    public void addRound() {
        intCurrentRound++; 
    }
    
    /**
     *
     * @return the current road of battle 
     */
    public int getRound() {
        return this.intCurrentRound;
    }
    
    
}
