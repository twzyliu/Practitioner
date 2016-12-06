package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Cards;
import com.thoughtworks.ketsu.domain.Payment;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by zyongliu on 06/12/16.
 */
public class PaymentApi {
    private String pid;
    private Card card;

    public PaymentApi(String pid, Card card) {
        this.pid = pid;
        this.card = card;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Payment getPayment(@Context Cards cards) {
        return cards.getPayment(pid);
    }
}
