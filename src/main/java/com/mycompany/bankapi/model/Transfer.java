/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aibsa
 */

@XmlRootElement
public class Transfer {
    
    private int customerId;
    private int accountNumber1;
    private int accountNumber2;
    private int amount;
    
    public Transfer(){
        
    }
    public Transfer(int customerId,int accountNumber1,int accountNumber2,int amount){
        
        this.accountNumber1=accountNumber1;
        this.accountNumber2=accountNumber2;
        this.amount=amount;
        this.customerId=customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAccountNumber1() {
        return accountNumber1;
    }

    public void setAccountNumber1(int accountNumber1) {
        this.accountNumber1 = accountNumber1;
    }

    public int getAccountNumber2() {
        return accountNumber2;
    }

    public void setAccountNumber2(int accountNumber2) {
        this.accountNumber2 = accountNumber2;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
