package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.domain.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zyongliu on 29/11/16.
 */
public class RecordsApi {

    private Card card;

    public RecordsApi(Card card) {
        this.card = card;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(HashMap<String, Object> info,
                           @Context Routes routes,
                           @Context Records records,
                           @Context CurrentCard currentCard) {
        Card current = currentCard.getCurrentCard();
        if (!card.equals(current)) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        Record record = records.create(info);
        if (record == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        record.setCard(card);
        return Response.status(201).location(routes.recordUrl(record)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Record> getAllRecords(@Context Records records) {
        List<Record> recordList = records.getAllRecords();
        if (recordList.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return recordList;
    }

}
