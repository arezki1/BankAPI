/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.services;

import com.mycompany.bankapi.model.Accounts;
import com.mycompany.bankapi.model.Transaction;
import static com.mycompany.bankapi.services.CustomerService.trans;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aibsa
 */

public class AccountsService {
    public static List<Transaction> trans=new ArrayList<>();
     public static List<Accounts> acc = new ArrayList<>();
     
        Accounts a1 = new Accounts(1, 1,4,9,  5.15, trans);
        Accounts a2 = new Accounts(2, 2,4,10, 10.5, trans);
        Accounts a3 = new Accounts(3, 3,4,10, 15.5, trans);
 public List<Accounts> getAccount(){
        
    // trans.add(trans);
        return acc;
    }
}
