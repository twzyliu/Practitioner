package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Bill;
import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Cards;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by zyongliu on 01/12/16.
 */
public class BillsApi {
    private Card card;

    public BillsApi(Card card) {
        this.card = card;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bill> getBills(@Context Cards cards) {
        return cards.getAllBills(card.getId());
    }
}
