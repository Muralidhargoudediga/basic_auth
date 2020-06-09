package com.restful.service;

import com.restful.model.ErrorResponse;
import com.restful.model.Order;
import junit.framework.TestCase;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.Base64;

public class OrderInventoryServiceTest extends TestCase {
    @Test
    public void test() {
        String url = "http://localhost:8080/basic_auth_demo_war";
        String name = "Murali";
        String password = "secured";
        String authString = name + ":" + password;
        String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());
        System.out.println("Base64 encoded auth string: " + authStringEnc);
        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFeature.class));
        WebTarget webTarget = client.target(url).path("/rest/order-inventory/order/1016");
        Invocation.Builder invocationBuilder = webTarget.request();
        invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic " + authStringEnc);
        Response response = invocationBuilder.get();

        if(response.getStatus() != 200){
            ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
            System.out.println(errorResponse);
        } else {
            Order output = response.readEntity(Order.class);
            System.out.println("response: "+output);
        }

        Assert.assertEquals(200, response.getStatus());
    }
}