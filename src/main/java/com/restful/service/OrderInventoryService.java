package com.restful.service;

import com.restful.model.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Base64;

@Path("/order-inventory")
public class OrderInventoryService {

    @GET
    @Path("/order/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("orderId") Integer orderId,
                                @HeaderParam("authorization") String authString){

        if(!isUserAuthenticated(authString)){
            return Response.status(Response.Status.UNAUTHORIZED).entity("{\"error\":\"User not authenticated\"}").build();
        }
        Order ord = new Order();
        ord.setCustmer("Murali");
        ord.setAddress("Bangalore");
        ord.setAmount("$2000");
        return Response.ok().entity(ord).build();
    }

    private boolean isUserAuthenticated(String authString){
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        bytes = Base64.getDecoder().decode(authInfo);
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);

        /**
         * here you include your logic to validate user authentication.
         * it can be using ldap, or token exchange mechanism or your
         * custom authentication mechanism.
         */
        // custom authentication mechanism
        String[] credentials = decodedAuth.split(":");
        if(credentials[0].equals("Murali") && credentials[1].equals("secure")){
            return true;
        }

        return false;
    }
}
