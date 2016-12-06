package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by zyongliu on 29/11/16.
 */
@Path("cards/{cid}")
public class CardApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Card getCard(@PathParam("cid") String cid,
                        @Context Cards cards,
                        @Context CurrentCard currentCard) {
        Card card = cards.getCard(cid);
        Card current = currentCard.getCurrentCard();
        if (card != null && card == current) {
            return card;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @Path("contract")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Contract getContract(@PathParam("cid") String cid,
                                @Context Cards cards,
                                @Context CurrentCard currentCard) {
        Card card = cards.getCard(cid);
        Card current = currentCard.getCurrentCard();
        if (card != null && card.getContract() != null && current == card) {
            return card.getContract();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @Path("records")
    public RecordsApi recordsApi(@PathParam("cid") String cid,
                                 @Context Cards cards) {
        Card card = cards.getCard(cid);
        return new RecordsApi(card);
    }

    @Path("bills")
    public BillsApi billsApi(@PathParam("cid") String cid,
                             @Context Cards cards) {
        Card card = cards.getCard(cid);
        return new BillsApi(card);
    }


    @Path("balance")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Balance getBalance(@PathParam("cid") String cid,
                              @Context Cards cards,
                              @Context CurrentCard currentCard) {
        Card current = currentCard.getCurrentCard();
        Card card = cards.getCard(cid);
        Balance balance = card.getBalance();
        if (balance == null || !card.equals(current)) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return balance;
    }


    @Path("payments")
    public PaymentsApi paymentsApi(@PathParam("cid") String cid,
                                   @Context Cards cards) {
        Card card = cards.getCard(cid);
        return new PaymentsApi(card);
    }

}

