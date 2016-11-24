package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.CurrentUser;
import com.thoughtworks.ketsu.domain.User;
import com.thoughtworks.ketsu.domain.Users;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by zyongliu on 22/11/16.
 */
public class UserApi {
    private User user;

    public UserApi(User user) {
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@Context Users users,
                        @Context CurrentUser currentUser) {
        return currentUser.getCurrentUser().filter(c -> c.equals(user)).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @Path("orders")
    public OrdersApi ordersApi() {
        return new OrdersApi(user);
    }

    @Path("refundorders")
    public RefundOrdersApi refundOrdersApi() {
        return new RefundOrdersApi(user);
    }

    @Path("products")
    public ProductsApi productsApi() {
        return new ProductsApi(user);
    }
}
