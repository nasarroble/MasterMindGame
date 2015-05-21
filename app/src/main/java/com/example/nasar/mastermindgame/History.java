/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.nasar.mastermindgame;

import java.io.Serializable;

/**
 *
 * @author nasar
 */
public class History implements Serializable {
    private int wins;
    private int losses;
    public History(){
        wins = 0;
        losses = 0;
    }
    
   public void addWins(){
       wins++;
   }
   public int getWins(){
       return wins;
   }
    public void addLoss(){
        losses++;
    }
    
    public int getLosses(){
        return losses;
    }
}
