/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.model.Accounts;
import com.mycompany.bankapi.model.Customer;
import com.mycompany.bankapi.model.Transaction;
import com.mycompany.bankapi.model.Transfer;
import com.mycompany.bankapi.services.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Maurice
 */@Path("/bank")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    
    CustomerService cService = new CustomerService();
    

    @GET
    @Path("/customers")
    public List<Customer> getCustomers() {
         return cService.getAllCustomers();
    }
    //create a customer
    @POST
    @Path("/createcust")
    public Customer postCustomer(Customer c){
        return cService.createCustomer(c);
    } 

    //create an account
    @POST
    @Path("{custId}/createacc")
    public Accounts postAccount(@PathParam("custId")int id, Accounts a){
      return cService.createAccount(a, id);
    }
    //get Customer by name

    @GET
    @Path("/customer/{customerName}")
    public String getCustomerName(@PathParam("customerName") String name){
      return cService.getCustomerName(name);
    }
    //get the customer by id
    @GET
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId") int id) {
        return cService.getCustomer(id);
    }
       
   //get the transaction by id
    @GET
    @Path("{custId}/acc/{accId}/trans/{transId}")
    public Transaction getTransaction(@PathParam("custId") int customerid,@PathParam("accId") int accountid,@PathParam("transId") int transid) {
        return cService.getTransaction(customerid, accountid,transid);
              
    }
     //get the transaction exceeding 10 euros
    @GET
    @Path("{custId}/acc/{accId}/transactionExceed")
    public Transaction getTransactionExceed(@PathParam("custId") int customerid,@PathParam("accId") int accountid) {
        return cService.getTransactionExceeding(customerid, accountid);
              
    }
     //get amount of a certain account
    @GET
    @Path("{custId}/acc/{accId}/amount")
    public String getAmount(@PathParam("custId") int customerid,@PathParam("accId") int accountid) {
        return cService.getAmount(customerid, accountid);
              
    }

    // Put money and get money
    @PUT
    @Path("transaction")
    public String postTransaction2(Transaction transaction){
               
            if( transaction.getType().equals("debit")){
             return "Amount debited is "+cService.putDebit(transaction);
        }
            
            else if(transaction.getType().equals("credit")){
                if(transaction.getAmount()<600){
                     return "Amount is "+cService.putCredit(transaction);
                }
             return "You cant get more than 600Euros Man, Go away!!";
        }
       
            return "Amount credited is "+cService.putCredit(transaction);
              
    }
    //create a transfer
    @PUT
    @Path("transfer")
    public String putTransfer(Transfer transfer){
            
         
            return  cService.putTransfer(transfer);
              
    }
    
       //delete an account
    @DELETE
    @Path("delete/{customerId}/account/{accountId}")
    public String deleteAccount(@PathParam("customerId") int customerId,@PathParam("accountId") int accountId){
            
         
            return  cService.deleteAccount(customerId,accountId);
              
    }
    
       //get number of customers
    @GET
    @Path("customersNumber")
    public int getCustomerNumber() {
        return cService.getCustomerNumber();
              
    }
    
       //get number of accounts
    @GET
    @Path("accountsNumber")
    public int accountsNumber() {
        return cService.getCustomerNumber();
              
    }
   
     //get transaction by customer id and account id
    @GET
    @Path("{customerId}/account/{accountId}/transactions")
    public int getTransactionsAccount(@PathParam("customerId") int customerId,@PathParam("accountId") int accountId){
            
         
            return  cService.getTransactionsAccount(customerId,accountId);
              
    }
    
     //get number of accounts by customer name
    @GET
    @Path("{accountId}/account/{name}")
    public int getAccountsByName(@PathParam("accountId") int customerId,@PathParam("name") String name){
            
         
            return  cService.getAccountsByName(name,customerId); 
              
    }
}
