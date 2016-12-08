package com.thoughtworks.ketsu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by zyongliu on 23/11/16.
 */
public interface Orders {
    Optional<Order> createOrder(Integer uid, HashMap<String, Object> orderInfo);

    Optional<Order> findByUidOid(Integer uid, Integer oid);

    List<Order> findAllByUid(Integer uid);

    Payment getPayment(Integer oid);
}
