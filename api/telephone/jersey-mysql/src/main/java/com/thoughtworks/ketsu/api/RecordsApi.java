package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Record;
import com.thoughtworks.ketsu.domain.Records;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

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
                           @Context Records records) {
        Record record = records.create(info);
        record.setCard(card);
        return Response.status(201).location(routes.recordUrl(record)).build();
    }
}
