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
public class RefundOrderApi {
    private RefundOrder refundOrder;

    public RefundOrderApi(RefundOrder refundOrder) {
        this.refundOrder = refundOrder;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RefundOrder getRefundOrder(@Context Users users,
                                      @Context CurrentUser currentUser) {
        return currentUser.getCurrentUser().filter((c) -> c.equals(refundOrder.getUser())).map((c) -> refundOrder).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @Path("refund")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Refund getRefund(@Context RefundOrders refundOrders,
                            @Context CurrentUser currentUser) {
        return currentUser.getCurrentUser().filter((c) -> (c.equals(refundOrder.getUser()) && (refundOrders.getRefund() != null))).map((c)-> refundOrders.getRefund()).orElseThrow(()-> new WebApplicationException(Response.Status.NOT_FOUND));
    }
}

