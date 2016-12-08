package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.Refund;
import com.thoughtworks.ketsu.domain.RefundOrder;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zyongliu on 08/12/16.
 */
public interface RefundOrderMapper {
    void create(@Param("uid") Integer uid, @Param("info") HashMap<String, Object> refundOrderInfo);

    RefundOrder findById(@Param("uid") Integer uid, @Param("roid") Integer roid);

    List<RefundOrder> findAllRefundOrder(@Param("uid") Integer uid);

    Refund findRefund(@Param("roid") Integer roid);
}
