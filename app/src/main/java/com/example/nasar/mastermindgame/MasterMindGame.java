/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.nasar.mastermindgame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nasar
 */
public class MasterMindGame {
     private ArrayList<CodePeg> clonePlayerCode, playerCodePegs;
     private  ArrayList<CodePeg> computerCodePegs; 
     private final ArrayList<KeyPeg> playerKeyPegs;
     private int currentNumGuesses; 
     private boolean winnerFlag;        
     private  int allowedGuesses;
     private Guess [] guessList;
     private Guess gameGuess;
    private static Random rand;
     
    /**
     *  constructor
     */
    public MasterMindGame(){
            winnerFlag = false;
            rand = new Random();
            currentNumGuesses = 0;
            allowedGuesses = 12;
            playerCodePegs = new ArrayList(4);
           computerCodePegs = new ArrayList(4);
           playerKeyPegs = new ArrayList(4);
          guessList = new Guess [allowedGuesses];
       
       // computerPickCode();
    }
    /**
     * 
     *  random computer code pegs.
     */
     private void computerPickCode() {

        for(int i = 0 ; computerCodePegs.size() < 4; i++){
           
            computerCodePegs.add(CodePeg.values()[rand.nextInt(6)]);
        }

    }
     
  
        
    /**
     *
     * @return the current number of the guesses
     */
    public int getNumOfGuesses(){
        return currentNumGuesses;
    }
    
    /**
     *
     * @param playerCode
     */
    public void setPlayerCode(ArrayList<CodePeg> playerCode){
        
        playerCodePegs = playerCode;

    }
    
    /**
     * checks if the player's code pegs match the computer's code pegs.
     * 
     */
    public void checkCode(){
        playerKeyPegs.clear();
clonePlayerCode = (ArrayList<CodePeg>) playerCodePegs.clone();
       
     if(isGameOver()|| playerCodePegs == null){
         return;
     }
     // If the player's code matches the computer's code pegs. The player wins
       else if(isPlayerWinner()){
           winnerFlag = true;
           for(int i = 0; i < 4; i++){
               setPlayerKeyPegs(KeyPeg.BLACK);
           }
        }
        
        // If any  of the player's pegs matches the computer's pegs 
        else{
           for(int i = 0; i < playerCodePegs.size(); i++){
               
               if(computerCodePegs.contains(playerCodePegs.get(i)))
                    comparePegs(i, playerCodePegs.get(i));

            }
           
            for(CodePeg peg: clonePlayerCode){
                if(computerCodePegs.contains(peg)){
                     setPlayerKeyPegs(KeyPeg.WHITE);
                     
                //cloneCompCode.remove(peg);
                }
            }
          }
         
     // creates new guess and add to the list of guesses, guestList
        gameGuess = new Guess();
        gameGuess.setPlayerGuesses(getPlayerCodePegs());
        gameGuess.setKeyGuesses(getPlayerKeyPegs());
        guessList[currentNumGuesses] = gameGuess;
        currentNumGuesses++;
       
  
    }
    /**
     *  decides if the player should be reward with black peg or white peg.
     * @param peg 
     */
private void comparePegs(int pos, CodePeg peg){
      
           if(computerCodePegs.get(pos).equals(peg)){
        
               setPlayerKeyPegs(KeyPeg.BLACK); 
                 clonePlayerCode.remove(peg);
             }
  
          
    }
    
    /**
     *
     * @return either the player guessed correctly of the number of guesses has been exceed.
     */
    public boolean isGameOver(){
    
        return currentNumGuesses >= allowedGuesses;
    }
    
    /**
     *
     * @return whether the player guessed it correctly or not
     */
    public boolean isPlayerWinner(){
       return playerCodePegs.equals(computerCodePegs);
   }
   /**
    * 
    * @param key 
    */
   private void setPlayerKeyPegs(KeyPeg key){
      playerKeyPegs.add(key);
   }

    /**
     *
     * @return an list of the key pegs as the result from the player's guess
     */
    public ArrayList<KeyPeg> getPlayerKeyPegs(){
      return playerKeyPegs;
    }

    /**
     *
     *  resets the game
     */
    public void resetGame(){
        currentNumGuesses = 0;
        guessList = new Guess [allowedGuesses];   
        playerCodePegs.clear(); 
        computerCodePegs.clear();
       computerPickCode();
      
        winnerFlag = false;
    }
    
    /**
     *
     * @return the players code pegs
     */
    public ArrayList<CodePeg> getPlayerCodePegs(){
        return playerCodePegs;
    }
   
    /**
     *
     * @return a list of the code pegs guessed by the player. A list of guesses
     */
    public Guess []  getGuessList(){
       return guessList;
   }
   
    /**
     * prevents the player from playing the same game after winning.
     * @return whether a won or not
     */
    public boolean getWinnerFlag(){
       return winnerFlag;
   }

    /**
     *
     * @return the computer's code pegs
     */
    public ArrayList<CodePeg> getComputerCode(){
       return computerCodePegs;
   }
   
    public void checkCode(ArrayList<CodePeg> code){
        setPlayerCode(code);
        checkCode();
        
    }
    
    public void setComputerCode(ArrayList<CodePeg> computerCode){
        computerCodePegs = computerCode;
    }
    
    public void setAllowedGuesses(int allowedGuesses){
        this.allowedGuesses = allowedGuesses;
    }
}
