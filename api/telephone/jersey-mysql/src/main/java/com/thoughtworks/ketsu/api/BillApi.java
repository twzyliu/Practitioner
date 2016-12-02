package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Bill;
import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Cards;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by zyongliu on 02/12/16.
 */
public class BillApi {
    private String bid;
    private Card card;

    public BillApi(String bid, Card card) {
        this.bid = bid;
        this.card = card;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bill getBill(@Context Cards cards) {
        Bill bill = cards.getBill(bid);
        if (bill == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return bill;
    }
}
