package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 09/12/16.
 */
public interface ProductMapper {
    void create(@Param("uid") Integer uid,@Param("info") Map<String, Object> productInfo);

    Product findById(@Param("pid") Integer pid);

    List<Product> findAll(@Param("uid") Integer uid);
}
