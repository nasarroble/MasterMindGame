/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.nasar.mastermindgame;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nasar
 */
public class Guess implements Serializable {
    private CodePeg[] pattern;
     private KeyPeg[] keys;
     
    /**
     *
     */
    public Guess(){
        pattern = new CodePeg [4];
        keys = new KeyPeg [4];
    }
    
    /**
     * adds the player codepegs to the guesses
     * @param codeGuess
     */
    public void setPlayerGuesses(ArrayList<CodePeg> codeGuess){
      int count =0;
      for(CodePeg peg: codeGuess){
          pattern[count] = peg;
          count++;
      }
     
  }

    /**
     * add the key code to the guesses
     * @param keyGuess
     */
    public void setKeyGuesses(ArrayList<KeyPeg> keyGuess){
        int count =0;
      for(KeyPeg peg: keyGuess){
          keys[count] = peg;
          count++;
      }
  }
  
    /**
     *  
     * @return the player's code guess
     */
    public CodePeg [] getPlayerGuesses(){
       return pattern;
   }

    /**
     *
     * @return the keyPegs that correspond to the players code
     */
    public KeyPeg [] getKeyGuesses(){
       return keys;
   }
}
