package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Product;
import com.thoughtworks.ketsu.domain.User;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by zyongliu on 23/11/16.
 */
public class ProductApi {

    private Product product;
    private User user;

    public ProductApi(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct() {
        return product;
    }
}
