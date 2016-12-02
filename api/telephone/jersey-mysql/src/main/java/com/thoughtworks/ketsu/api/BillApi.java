package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Bill;
import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Cards;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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
        return cards.getBill(bid);
    }
}
