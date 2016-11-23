package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * Created by zyongliu on 23/11/16.
 */
public class OrderApi {
    private Order order;
    private User user;

    public OrderApi(Order order, User user) {
        this.order = order;
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Order findByUidOid(@Context Users users,
                              @Context CurrentUser currentUser) {
        Optional<User> current = currentUser.getCurrentUser();
        if (current.isPresent() && current.get().equals(user)) {
            return order;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @Path("payment")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Payment getPayment(@Context Users users,
                              @Context CurrentUser currentUser,
                              @Context Orders orders) {
        Optional<User> current = currentUser.getCurrentUser();
        Payment payment = orders.getPayment();
        if (payment != null && current.isPresent() && current.get().equals(user)) {
            return payment;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

}
