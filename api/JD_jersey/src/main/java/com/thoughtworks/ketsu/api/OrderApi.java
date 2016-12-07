package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by zyongliu on 23/11/16.
 */
public class OrderApi {
    private Order order;

    public OrderApi(Order order) {
        this.order = order;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Order findByUidOid(@Context Users users,
                              @Context CurrentUser currentUser) {
        return currentUser.getCurrentUser().filter(c -> c.getId().equals(order.getUid())).map(c -> order).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @Path("payment")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Payment getPayment(@Context Users users,
                              @Context CurrentUser currentUser,
                              @Context Orders orders) {
        return currentUser.getCurrentUser().filter(c -> (c.getId().equals(order.getUid()) && (orders.getPayment(order.getId()) != null))).map(c -> orders.getPayment(order.getId())).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }
}
