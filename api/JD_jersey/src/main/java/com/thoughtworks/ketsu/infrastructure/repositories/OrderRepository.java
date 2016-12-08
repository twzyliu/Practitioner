package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.Order;
import com.thoughtworks.ketsu.domain.Orders;
import com.thoughtworks.ketsu.domain.Payment;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by zyongliu on 07/12/16.
 */
public class OrderRepository implements Orders {
    @Inject
    OrderMapper orderMapper;

    @Inject
    UserMapper userMapper;

    @Override
    public Optional<Order> createOrder(Integer uid, HashMap<String, Object> orderInfo) {
        orderMapper.createOrder(uid, orderInfo);
        return findByUidOid(uid, Integer.parseInt(orderInfo.getOrDefault("id", "").toString()));
    }

    @Override
    public Optional<Order> findByUidOid(Integer uid, Integer oid) {
        Order order = orderMapper.findById(oid);
        order.setUid(userMapper.findById(uid).getId());
        return Optional.of(order);
    }

    @Override
    public List<Order> findAllByUid(Integer uid) {
        return orderMapper.findAll(uid);
    }

    @Override
    public Payment getPayment(Integer oid) {
        return orderMapper.findPaymentByOid(oid);
    }
}
