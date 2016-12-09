package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.Product;
import com.thoughtworks.ketsu.domain.Products;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ProductMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by zyongliu on 09/12/16.
 */
public class ProductRepository implements Products {
    @Inject
    ProductMapper productMapper;

    @Override
    public Optional<Product> create(Integer uid, Map<String, Object> info) {
        productMapper.create(uid, info);
        return findProduct(Integer.parseInt(info.getOrDefault("id", "").toString()));
    }

    @Override
    public List<Product> findAllProducts(Integer uid) {
        return productMapper.findAll(uid);
    }

    @Override
    public Optional<Product> findProduct(Integer pid) {
        return Optional.of(productMapper.findById(pid));
    }

}
