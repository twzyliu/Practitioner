package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.domain.CurrentUser;
import com.thoughtworks.ketsu.domain.Product;
import com.thoughtworks.ketsu.domain.Products;
import com.thoughtworks.ketsu.domain.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by zyongliu on 23/11/16.
 */
public class ProductsApi {
    private User user;

    public ProductsApi(User user) {
        this.user = user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> productInfo,
                           @Context Products products,
                           @Context Routes routes,
                           @Context CurrentUser currentUser) {
        Optional<Product> product = products.create(user.getId(), productInfo);
        return currentUser.getCurrentUser().filter(c -> (c.equals(user) && (product != null))).map((c) -> Response.status(201).location(routes.productUrl(product.get())).build()).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts(@Context Products products) {
        return products.findAllProducts(user.getId()).stream().findFirst().map((p) -> products.findAllProducts(user.getId())).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @Path("{pid}")
    public ProductApi productApi(@PathParam("pid") Integer pid,
                                 @Context Products products) {
        return products.findProduct(pid).map(ProductApi::new).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }
}
