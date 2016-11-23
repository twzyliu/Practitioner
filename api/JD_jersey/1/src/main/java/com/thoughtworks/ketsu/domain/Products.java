package com.thoughtworks.ketsu.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by zyongliu on 23/11/16.
 */
public interface Products {
    Product create(Map<String, Object> productInfo);

    List<Product> findAllProducts();

    Optional<Product> findProduct(long pid);
}
