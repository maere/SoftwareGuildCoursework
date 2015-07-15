/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interestcalculatorwebapp;

/**
 *
 * @author apprentice
 */
public class FiscalYear {
    private int year;
    private float currentBalance;
    private float endPrinciple;
    private float yearInterest; //this will get set on the object when running acrruedInterest
    
    public FiscalYear(){
     
    
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public float getEndPrinciple() {
        return endPrinciple;
    }

    public void setEndPrinciple(float endPrinciple) {
        this.endPrinciple = endPrinciple;
    }

    public float getYearInterest() {
        return yearInterest;
    }

    public void setYearInterest(float yearInterest) {
        this.yearInterest = yearInterest;
    }
    
    
    
}
