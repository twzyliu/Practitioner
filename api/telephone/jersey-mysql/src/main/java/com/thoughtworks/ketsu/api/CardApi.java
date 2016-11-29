package com.thoughtworks.ketsu.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public Response getCardInfo(@PathParam("cid") String cid) {
        return Response.status(200).build();
    }
}
