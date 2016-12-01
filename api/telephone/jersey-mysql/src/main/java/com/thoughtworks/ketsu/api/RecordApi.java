package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Record;
import com.thoughtworks.ketsu.domain.Records;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by zyongliu on 29/11/16.
 */
public class RecordApi {
    private Card card;
    private String rid;

    public RecordApi(Card card, String rid) {
        this.card = card;
        this.rid = rid;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Record getRecord(@Context Records records) {
        Record record = records.getRecord(rid);
        if (record == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return record;
    }

}
