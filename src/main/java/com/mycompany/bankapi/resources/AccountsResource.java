/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.model.Customer;
import com.mycompany.bankapi.services.AccountsService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author aibsa
 */

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountsResource {
    
    AccountsService accs = new AccountsService();
    @POST
    @Path("/{putAmount}")
     public double postAmount(double putAmount) {
       // return accs.postAmount(putAmount);
       return 2.5;
    }
}
