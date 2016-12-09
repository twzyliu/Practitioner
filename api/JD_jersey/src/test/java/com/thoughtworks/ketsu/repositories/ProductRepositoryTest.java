package com.thoughtworks.ketsu.repositories;

import com.thoughtworks.ketsu.domain.Product;
import com.thoughtworks.ketsu.domain.User;
import com.thoughtworks.ketsu.infrastructure.repositories.ProductRepository;
import com.thoughtworks.ketsu.infrastructure.repositories.UserRepository;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zyongliu on 09/12/16.
 */
@RunWith(DatabaseTestRunner.class)
public class ProductRepositoryTest {
    @Inject
    ProductRepository productRepository;

    @Inject
    UserRepository userRepository;

    private User user;
    private Product product;

    @Before
    public void setUp() throws Exception {
        user = userRepository.create(TestHelper.userInfo).get();
        product = productRepository.create(user.getId(), new HashMap<>()).get();
    }

    @Test
    public void should_return_product_when_create() throws Exception {
        assertThat(product.getUid(), is(user.getId()));
    }

    @Test
    public void should_return_product_when_find_by_id() throws Exception {
        Product byId = productRepository.findProduct(product.getId()).get();
        assertThat(byId.getId(), is(product.getId()));
    }

    @Test
    public void should_return_products_when_find_all() throws Exception {
        List<Product> allProducts = productRepository.findAllProducts(user.getId());
        assertThat(allProducts.size() > 0, is(true));
        assertThat(allProducts.get(0).getUid(), is(user.getId()));
    }
}
