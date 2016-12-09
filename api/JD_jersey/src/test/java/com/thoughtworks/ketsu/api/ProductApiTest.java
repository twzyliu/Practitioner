package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.api.jersey.RoutesFeature;
import com.thoughtworks.ketsu.domain.CurrentUser;
import com.thoughtworks.ketsu.domain.Products;
import com.thoughtworks.ketsu.domain.Users;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.thoughtworks.ketsu.support.TestHelper.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 23/11/16.
 */
public class ProductApiTest extends JerseyTest {
    private CurrentUser currentUser;
    private Users users;
    private Products products;

    @Override
    protected Application configure() {
        return new ResourceConfig(RoutesFeature.class)
                .packages("com.thoughtworks.ketsu")
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(currentUser).to(CurrentUser.class);
                        bind(users).to(Users.class);
                        bind(products).to(Products.class);
                    }
                });
    }

    @Override
    @Before
    public void setUp() throws Exception {
        users = mock(Users.class);
        currentUser = mock(CurrentUser.class);
        products = mock(Products.class);
        when(currentUser.getCurrentUser()).thenReturn(Optional.of(user));
        when(users.findById(any())).thenReturn(Optional.of(user));
        when(products.create(anyInt(), any())).thenReturn(Optional.of(product));
        when(products.findAllProducts(anyInt())).thenReturn(productList);
        when(products.findProduct(eq(product.getId()))).thenReturn(Optional.of(product));
        super.setUp();
    }

    @Test
    public void should_return_201_when_user_creat_product() throws Exception {
        Response response = target(String.format("/users/%s/products", user.getId())).request().post(Entity.json(product));

        assertThat(response.getStatus(), is(201));
        assertThat(response.getLocation().toString().contains(product.getId() + ""), is(true));
    }

    @Test
    public void should_return_404_when_user_creat_product_fail() throws Exception {
        when(products.create(anyInt(), any())).thenReturn(null);
        Response response = target(String.format("/users/%s/products", user.getId())).request().post(Entity.json(product));

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_404_when_other_creat_my_product() throws Exception {
        when(users.findById(any())).thenReturn(Optional.of(otherUser));
        Response response = target(String.format("/users/%s/products", user.getId())).request().post(Entity.json(product));

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_200_when_user_get_all_products() throws Exception {
        Response response = target(String.format("/users/%s/products", user.getId())).request().get();

        assertThat(response.getStatus(), is(200));
        List<Map<String, Object>> maps = response.readEntity(List.class);
        assertThat(maps.size(), is(productList.size()));
        for (int i = 0;i<productList.size();i++) {
            assertThat(maps.get(i).getOrDefault("id","").toString(), is(productList.get(i).getId()+""));
            assertThat(maps.get(i).getOrDefault("url","").toString().contains(productList.get(i).getId()+""), is(true));
        }
    }

    @Test
    public void should_return_404_when_user_no_products() throws Exception {
        when(products.findAllProducts(anyInt())).thenReturn(Collections.emptyList());
        Response response = target(String.format("/users/%s/products", user.getId())).request().get();

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_200_when_user_get_product() throws Exception {
        Response response = target(String.format("/users/%s/products/%s", user.getId(),product.getId())).request().get();

        assertThat(response.getStatus(), is(200));
        Map<String, Object> map = response.readEntity(Map.class);
        assertThat(map.getOrDefault("id", "").toString(), is(product.getId() + ""));
        assertThat(map.getOrDefault("url","").toString().contains(product.getId()+""), is(true));
    }

    @Test
    public void should_return_404_when_user_no_product() throws Exception {
        when(products.findProduct(eq(product.getId()))).thenReturn(Optional.empty());
        Response response = target(String.format("/users/%s/products/%s", user.getId(),product.getId())).request().get();

        assertThat(response.getStatus(), is(404));
    }
}

