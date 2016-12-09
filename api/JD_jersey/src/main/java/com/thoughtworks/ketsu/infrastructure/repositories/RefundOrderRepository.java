package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.Refund;
import com.thoughtworks.ketsu.domain.RefundOrder;
import com.thoughtworks.ketsu.domain.RefundOrders;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.RefundOrderMapper;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by zyongliu on 08/12/16.
 */
public class RefundOrderRepository implements RefundOrders {
    @Inject
    RefundOrderMapper refundOrderMapper;

    @Override
    public Optional<RefundOrder> create(Integer uid, HashMap<String, Object> refundOrderInfo) {
        refundOrderMapper.create(uid, refundOrderInfo);
        return findByUidRoid(uid, Integer.parseInt(refundOrderInfo.getOrDefault("id", "").toString()));
    }

    @Override
    public List<RefundOrder> findAllRefundOrder(Integer uid) {
        return refundOrderMapper.findAllRefundOrder(uid);
    }

    @Override
    public Optional<RefundOrder> findByUidRoid(Integer uid, Integer roid) {
        return Optional.of(refundOrderMapper.findById(uid, roid));
    }

    @Override
    public Refund findRefund(Integer roid) {
        return refundOrderMapper.findRefund(roid);
    }

}
