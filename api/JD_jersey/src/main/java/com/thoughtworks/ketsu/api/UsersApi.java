package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.CurrentUser;
import com.thoughtworks.ketsu.domain.Users;
import com.thoughtworks.ketsu.api.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by zyongliu on 22/11/16.
 */
@Path("users")
public class UsersApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(HashMap<String,Object> info,
                           @Context Users users,
                           @Context Routes routes,
                           @Context CurrentUser currentUser) {
        return users.create(info).map(u -> Response.status(201).location(routes.userUrl(Optional.of(u).get())).build()).orElseThrow(() -> new WebApplicationException(Response.Status.BAD_REQUEST));
    }

    @Path("{uid}")
    public UserApi userApi(@PathParam("uid") String uid,
                           @Context Users users) {
        return users.findById(uid).map(UserApi::new).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }
}
