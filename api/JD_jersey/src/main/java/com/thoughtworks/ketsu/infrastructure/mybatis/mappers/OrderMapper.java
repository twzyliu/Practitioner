package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.Order;
import com.thoughtworks.ketsu.domain.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zyongliu on 07/12/16.
 */
public interface OrderMapper {
    void createOrder(@Param("uid") String uid, @Param("info") HashMap<String, Object> orderInfo);

    Order findById(@Param("oid") Integer oid);

    List<Order> findAll(@Param("uid") Integer uid);

    Payment findPaymentByOid(@Param("oid") Integer oid);
}