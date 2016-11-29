package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Cards;
import com.thoughtworks.ketsu.domain.CurrentCard;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by zyongliu on 29/11/16.
 */
@Path("cards")
public class CardApi {

    @Path("{cid}")
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
}
