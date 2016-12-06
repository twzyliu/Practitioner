package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Cards;
import com.thoughtworks.ketsu.domain.Payment;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zyongliu on 06/12/16.
 */
public class PaymentsApi {

    private Card card;

    public PaymentsApi(Card card) {

        this.card = card;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPayment(HashMap<String, Object> info,
                                  @Context Cards cards,
                                  @Context Routes routes) {
        Payment payment = cards.createPayment(card, info);
        if (payment == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return Response.status(201).location(routes.paymentUrl(payment)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getAllPayments(@Context Cards cards) {
        List<Payment> paymentList = cards.getAllPayments();
        if (paymentList == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return paymentList;
    }
}
