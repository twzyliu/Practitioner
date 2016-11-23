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
public class RefundOrderApi {
    private RefundOrder refundOrder;
    private User user;

    public RefundOrderApi(RefundOrder refundOrder, User user) {
        this.refundOrder = refundOrder;
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RefundOrder getRefundOrder(@Context Users users,
                                      @Context CurrentUser currentUser) {
        Optional<User> current = currentUser.getCurrentUser();
        if (current.isPresent() && current.get().equals(user)) {
            return refundOrder;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @Path("refund")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Refund getRefund(@Context RefundOrders refundOrders,
                            @Context CurrentUser currentUser) {
        Optional<User> current = currentUser.getCurrentUser();
        Refund refund = refundOrders.getRefund();
        if (refund != null && current.isPresent() && current.get().equals(user)) {
            return refund;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}

