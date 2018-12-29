/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.resources;


import com.mycompany.bankapi.services.TransactionService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author aibsa
 */

@Path("/trans")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TranssactionResource {
    
    TransactionService transervice=new TransactionService();
    
    @POST
    @Path("/withdraw")
    public double getMessage(@PathParam("amount") double amount) {
        
        return transervice.lodge(amount);
    }
    
}
