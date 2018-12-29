/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.services;
import com.mycompany.bankapi.model.Accounts;
import com.mycompany.bankapi.model.Customer;
import com.mycompany.bankapi.model.Transaction;
import com.mycompany.bankapi.model.Transfer;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Maurice
 */
public class CustomerService {
    public static List<Customer> list = new ArrayList<>();
    public static List<Accounts> acc = new ArrayList<>();
    public static List<Transaction> trans=new ArrayList<>();
     
    public static boolean init = true;
    
    public CustomerService() {
     if (init) {
        
        Accounts a1 = new Accounts(1, 1,4,9,  100.00, trans);
        Accounts a2 = new Accounts(2, 2,4,10, 200.00, trans);
        Accounts a3 = new Accounts(3, 3,4,10, 300.00, trans);
        acc.add(a1);
        acc.add(a2);
        acc.add(a3);
        
        Customer c1 = new Customer(1,"Maurice", "Swords, Dublin",  "maur@email.com", "bankaccount", acc);
        Customer c2 = new Customer(2,"Arezki", "Clontarf, Dublin", "arezki@email.com", "bankaccount",acc);
        Customer c3 = new Customer(3,"Manuel", "Clontarf, Dublin", "arezki@email.com", "bankaccount",acc);
         
        list.add(c1);
        list.add(c2);
        list.add(c3);
        
    Transaction t1=new Transaction(1,"debit",1,25,"first withdrw",25.00);
    Transaction t2=new Transaction(2,"debit",2,2,"second withdrw",2.00);
    Transaction t3=new Transaction(3,"credit",3,3,"first debit",3.00);
    
    trans.add(t1);
    trans.add(t2);
    trans.add(t3);
        init = false;
     }
    }
        public List<Customer> getAllCustomers(){
        return list;
    }
    
    public Customer getCustomer(int id) {
        return list.get(id-1);
    }
       
    

    public Accounts getAccount(int id) {
        return acc.get(id-1);
    }
        //Handling the getting customer by name
    public String getCustomerName(String name){
       
      for(Customer c:list){
        try{
                if(c.getName().equals(name)){
                return "Yes, "+name+" Exist in the database";
                }
            }     
        catch(Exception e){
        e.getMessage();
          }
             
        }
          
        return name+" Does not exist";
    }
    
    //get a transaction by id
    public Transaction getTransaction(int customerId, int accountId,int transactionId){
        
        Transaction t=new Transaction();
        
        try{
            if((getCustomer(customerId).getId()==customerId)&&(getAccount(accountId).getAccountNumber()==accountId)){
               for (Transaction q: getAccount(accountId).getTrans()) {
                   if (q.getTransId() == transactionId) {
                           t = q;
               }
               }
                  }
          }
        
    catch(Exception e){
        e.getMessage();
        }
                    
        return t;
    }
    

        //handling the put transactions for debit
    public double putDebit(Transaction transaction){
       double newBalance=0.0;
        if(transaction.getAccountNumber()==getAccount(transaction.getAccountNumber()).getAccountNumber()){
                 
        try{
                double balance=getAccount(transaction.getAccountNumber()).getBalance();
                newBalance=balance+transaction.getAmount();
                getAccount(transaction.getAccountNumber()).setBalance(newBalance);

                return newBalance;
            }
        
        catch(Exception e){
            e.getMessage();
            }
        } 
        return newBalance;
    }

    //create a new customer
    public Customer createCustomer(Customer c){
        c.setId(list.size()+1);
        list.add(c);
        System.out.println("201 - resource created with path: /createcust/" + String.valueOf(c.getId()));
	return c;
    }
      //create an account
    public Accounts createAccount(Accounts a, int customerid){
        Customer c = new Customer();
        try{
            if(getCustomer(customerid).getId()==customerid){
                a.setId(list.size()+1);
                acc.add(a);
                System.out.println("201 - resource created with path: /createacc/" + String.valueOf(a.getId()));
        
            }
        
        }
        catch(Exception e){
        e.getMessage();
        }
        return a;
        
    }

   
          //handling the put transactions for debit
    public double putCredit(Transaction transaction){
       double newBalance=0.0;
        if(transaction.getAccountNumber()==getAccount(transaction.getAccountNumber()).getAccountNumber()){
                 
        try{
                double balance=getAccount(transaction.getAccountNumber()).getBalance();
                newBalance=balance-transaction.getAmount();
                getAccount(transaction.getAccountNumber()).setBalance(newBalance);

                return newBalance;
            }
        
        catch(Exception e){
            e.getMessage();
            }
        } 
        return newBalance;
    }
       

    
    
    public String putTransfer(Transfer transfer){
        
        int accountNumber1=transfer.getAccountNumber1();
        int accountNumber2=transfer.getAccountNumber2();
        int customerId=transfer.getCustomerId();             
        double amount=transfer.getAmount();
        double result =0.0;
        double amount1=getAccount(accountNumber1).getBalance()-amount;
        result=getAccount(accountNumber2).getBalance()+amount;
        try{
            if((getCustomer(customerId).getId()==customerId)&&(getAccount(accountNumber1).getAccountNumber()==accountNumber1)&&(getAccount(accountNumber2).getAccountNumber()==accountNumber2)){
      
                return "Account1 is now: "+amount1+" and account2 is: "+result;
           
                }   
              
            }
    catch(Exception e){
        e.getMessage();
        }
                    
   
        
        return "Account1 is now: "+amount1+" and account2 is: "+result;
        
    }
    
    //handling deleting account
    
    public String deleteAccount(int customerId,int accountId){
    
        
        System.out.println(getCustomer(customerId).getId());
        System.out.println(customerId);
        System.out.println(getAccount(accountId).getAccountNumber());
         System.out.println(accountId);
        
        
          if(getCustomer(customerId).getId()==customerId){
             try{
                 
                  if(getAccount(accountId).getAccountNumber()==accountId){
                       System.out.println("before deleted");
                     acc.remove(getAccount(accountId));
                     System.out.println("after deleted");
                                         
                  }
              
             }
             catch(Exception e){
                  e.getMessage();
             }
              
          }  
        
        return "deleted";
    }
    
    //    get all transactions for an account by account id - 
    public Transaction getTransactionbyAccId(int customerid, int accNo) {

        Accounts a = new Accounts();
        Transaction t = new Transaction();

        try {
            if (getCustomer(customerid).getId() == customerid) {
                for(Transaction q: getAccount(accNo).getTrans()){
                if (getAccount(accNo).getAccountNumber()== accNo) {
                    a.getTrans();
                }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return t;

    }
    
    //get Amount
        public String getAmount(int customerId, int accountId) {
        double amount=getAccount(accountId).getBalance();
        if(getCustomer(customerId).getId()==customerId){
            if(getAccount(accountId).getId()==accountId){
                
                return "Amount is"+ amount;
            }
        }
      
        return "Amount is"+amount;
    }
    //get a transaction by id
    public Transaction getTransactionExceeding(int customerId, int accountId){
        
        Transaction t=new Transaction();
        
        try{
            if((getCustomer(customerId).getId()==customerId)&&(getAccount(accountId).getAccountNumber()==accountId)){
               for (Transaction q: getAccount(accountId).getTrans()) {
                                   
                   if(q.getAmount()>10){
                       return t;
                   }
               
               }
                  }
          }
        
    catch(Exception e){
        e.getMessage();
        }
                    
        return null;
    }
    
    //getting number of customer
    
    public int getCustomerNumber(){
        
        return list.size();
    }
     
    //getting number of accounts
    
    public int getAccountsNumber(){
        
        return acc.size();
    }
        public int getTransactionsAccount(int customerId,int accountId){
        
           if(getCustomer(customerId).getId()==customerId){
             try{
                 
                  if(getAccount(accountId).getAccountNumber()==accountId){
                     
                     return  trans.size();                  
                  }
              
             }
             catch(Exception e){
                  e.getMessage();
             }
              
          }  
           
           return 0;
    }
        
        //handle getting number of accounts by customer name
        
        public int getAccountsByName(String name, int accountId){
            
            for(Customer c:list){
        try{
                if((c.getName().equals(name))&&(getAccount(accountId).getId()==accountId)){
                return acc.size();
                }
            }     
        catch(Exception e){
        e.getMessage();
          }
             
        }
          
            return 2;
        }
    
}
