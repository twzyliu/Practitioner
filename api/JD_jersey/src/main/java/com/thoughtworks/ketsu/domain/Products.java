package com.thoughtworks.ketsu.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by zyongliu on 23/11/16.
 */
public interface Products {
    Optional<Product> create(Integer uid, Map<String, Object> productInfo);

    List<Product> findAllProducts(Integer uid);

    Optional<Product> findProduct(Integer pid);
}
