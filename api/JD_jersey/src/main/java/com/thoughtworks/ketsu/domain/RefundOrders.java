package com.thoughtworks.ketsu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by zyongliu on 23/11/16.
 */
public interface RefundOrders {
    Optional<RefundOrder> create(Integer uid, HashMap<String, Object> refundOrderInfo);

    List<RefundOrder> findAllRefundOrder(Integer uid);

    Optional<RefundOrder> findByUidRoid(Integer uid, Integer roid);

    Refund findRefund(Integer oid);
}
