/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.exceptions.field;

/**
 *
 * Exception saat mencoba attack selain saat battle phase
 */
public class BattleAllowedException extends Exception{
    public BattleAllowedException(String exception){
        super(exception);
    }
}
