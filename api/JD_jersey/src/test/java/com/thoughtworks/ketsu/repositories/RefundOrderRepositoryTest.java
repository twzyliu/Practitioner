package com.thoughtworks.ketsu.repositories;

import com.thoughtworks.ketsu.domain.Refund;
import com.thoughtworks.ketsu.domain.RefundOrder;
import com.thoughtworks.ketsu.domain.User;
import com.thoughtworks.ketsu.infrastructure.repositories.RefundOrderRepository;
import com.thoughtworks.ketsu.infrastructure.repositories.UserRepository;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zyongliu on 08/12/16.
 */
@RunWith(DatabaseTestRunner.class)
public class RefundOrderRepositoryTest {
    private User user;

    @Inject
    UserRepository userRepository;

    @Inject
    RefundOrderRepository refundOrderRepository;
    private Optional<RefundOrder> refundOrder;

    @Before
    public void setUp() throws Exception {
        user = userRepository.create(TestHelper.userInfo).get();
        refundOrder = refundOrderRepository.create(user.getId(), new HashMap<>());
    }

    @Test
    public void should_return_refundorder_when_create() throws Exception {
        assertThat(refundOrder.get().getUid(), is(user.getId()));
    }

    @Test
    public void should_return_refundorder_when_find_by_id() throws Exception {
        Optional<RefundOrder> byUidRoid = refundOrderRepository.findByUidRoid(user.getId(), refundOrder.get().getId());
        assertThat(byUidRoid.get().getId(), is(refundOrder.get().getId()));
    }

    @Test
    public void should_return_refundorders_when_find_all() throws Exception {
        List<RefundOrder> allRefundOrder = refundOrderRepository.findAllRefundOrder(user.getId());
        assertThat(allRefundOrder.size() > 0, is(true));
        assertThat(allRefundOrder.get(0).getUid(), is(user.getId()));
    }

    @Test
    public void should_return_refund_when_find_by_id() throws Exception {
        Refund refund = refundOrderRepository.findRefund(TestHelper.REFUND_ID);
        assertThat(refund.getRoid(), is(TestHelper.REFUND_ID));
    }

}
