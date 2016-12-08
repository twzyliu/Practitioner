package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.domain.CurrentUser;
import com.thoughtworks.ketsu.domain.RefundOrder;
import com.thoughtworks.ketsu.domain.RefundOrders;
import com.thoughtworks.ketsu.domain.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by zyongliu on 23/11/16.
 */
public class RefundOrdersApi {
    private User user;

    public RefundOrdersApi(User user) {
        this.user = user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(HashMap<String, Object> refundOrderInfo,
                           @Context RefundOrders refundOrders,
                           @Context Routes routes,
                           @Context CurrentUser currentUser) {
        Optional<RefundOrder> refundOrder = refundOrders.create(user.getId(), refundOrderInfo);
        return currentUser.getCurrentUser().filter(c -> (c.equals(user) && (refundOrder.isPresent()))).map((c) -> Response.status(201).location(URI.create(routes.refundOrderUrl(refundOrder.get()).toString())).build()).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RefundOrder> getByUidRoid(@Context RefundOrders refundOrders,
                                          @Context CurrentUser currentUser) {
        return currentUser.getCurrentUser().filter(c -> (c.equals(user) && (refundOrders.findAllRefundOrder(user.getId()).size() > 0))).map((c) -> refundOrders.findAllRefundOrder(user.getId())).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @Path("{roid}")
    public RefundOrderApi refundOrderApi(@PathParam("roid") Integer roid,
                                         @Context RefundOrders refundOrders) {
        return refundOrders.findByUidRoid(user.getId(), roid).map(RefundOrderApi::new).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }
}
