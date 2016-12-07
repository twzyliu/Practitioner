package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.domain.CurrentUser;
import com.thoughtworks.ketsu.domain.Order;
import com.thoughtworks.ketsu.domain.Orders;
import com.thoughtworks.ketsu.domain.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by zyongliu on 23/11/16.
 */
public class OrdersApi {
    private User user;

    public OrdersApi(User user) {
        this.user = user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(HashMap<String, Object> orderInfo,
                                @Context Orders orders,
                                @Context Routes routes,
                                @Context CurrentUser currentUser) {
        Optional<Order> order = orders.createOrder(user, orderInfo);
        currentUser.getCurrentUser().filter((c) -> (c.equals(user))).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
        return order.filter((o) -> o != null).map((o) -> Response.status(201).location(routes.orderUrl(order.get())).build()).orElseThrow(() -> new WebApplicationException(Response.Status.BAD_REQUEST));
    }

    @Path("{oid}")
    public OrderApi orderApi(@PathParam("oid") Integer oid,
                             @Context Orders orders) {
        return orders.findByUidOid(user.getUsername(), oid).map(OrderApi::new).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrders(@Context Orders orders,
                                 @Context CurrentUser currentUser) {
        return currentUser.getCurrentUser().filter((c) -> (c.equals(user) && (orders.findAllByUid(user.getId()).size() > 0))).map((c) -> orders.findAllByUid(user.getId())).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }
}
