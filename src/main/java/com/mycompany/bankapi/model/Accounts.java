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
 * @author Maurice
 */
@XmlRootElement
public class Accounts {
    private int id;
    private int accountNumber;
    private int sortCode;
    private int customerId;
    private double balance;
    private List <Transaction> trans;
    
    public Accounts(){
        
    }
    
    public Accounts(int id, int accountNumber, int sortCode, int customerid, double balance,List <Transaction> trans ){
        this.id=id;
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.customerId = customerid;
        this.balance = balance;
        this.trans=trans;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    public List<Transaction> getTrans() {
        return trans;
    }

    public void setTrans(List<Transaction> trans) {
        this.trans = trans;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }
    


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
