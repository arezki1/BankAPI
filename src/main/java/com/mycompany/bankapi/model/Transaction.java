/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aibsa
 */
@XmlRootElement
public class Transaction {
    
    private int transId;
    private String description;
    private int accountNumber;
    private String type;
    private double amount;
    private double postTransaction;
    private Date created;
    
    public Transaction(){
        
    }
     public Transaction(int transId, String type, int accountNumber,double amount,String description, double postTransaction){
        this.created=new Date();
        this.transId=transId;
        this.accountNumber=accountNumber;
        this.type=type;
        this.amount=amount;
        this.description=description;
        this.postTransaction=postTransaction;
            }

    public String getDescription() {
        return description;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int tranId) {
        this.transId = transId;
    }

    public String getType() {
        return type;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPostTransaction() {
        return postTransaction;
    }

    public void setPostTransaction(double postTransaction) {
        this.postTransaction = postTransaction;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
     
     
}
