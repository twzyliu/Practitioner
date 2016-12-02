package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Bill;
import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Cards;
import com.thoughtworks.ketsu.domain.CurrentCard;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public List<Bill> getBills(@Context Cards cards,
                               @Context CurrentCard currentCard) {
        Card current = currentCard.getCurrentCard();
        List<Bill> billList = cards.getAllBills(card.getId());
        if (billList.size() == 0 || !card.equals(current)) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return billList;
    }

    @Path("{bid}")
    public BillApi billApi(@PathParam("bid") String bid) {
        return new BillApi(bid,card);
    }
}
