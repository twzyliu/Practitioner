package com.thoughtworks.ketsu.repositories;

import com.thoughtworks.ketsu.domain.Order;
import com.thoughtworks.ketsu.domain.Payment;
import com.thoughtworks.ketsu.domain.User;
import com.thoughtworks.ketsu.infrastructure.repositories.OrderRepository;
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
 * Created by zyongliu on 07/12/16.
 */
@RunWith(DatabaseTestRunner.class)
public class OrderRepositoryTest {
    @Inject
    OrderRepository orderRepository;

    @Inject
    UserRepository userRepository;

    private User user;

    @Before
    public void setUp() throws Exception {
        user = userRepository.create(TestHelper.userInfo).get();
    }

    @Test
    public void should_return_order_when_create_order() throws Exception {
        Optional<Order> order = orderRepository.createOrder(user.getId(), new HashMap<>());
        assertThat(order.get().getUid(), is(user.getId()));
    }

    @Test
    public void should_return_order_when_find_by_uid_oid() throws Exception {
        Optional<Order> order = orderRepository.createOrder(user.getId(), new HashMap<>());
        Optional<Order> byUidOid = orderRepository.findByUidOid(user.getId(), order.get().getId());
        assertThat(byUidOid.get().getId(), is(order.get().getId()));
    }

    @Test
    public void should_return_orders_when_find_by_uid() throws Exception {
        Optional<Order> order = orderRepository.createOrder(user.getId(), new HashMap<>());
        List<Order> allByUid = orderRepository.findAllByUid(user.getId());
        assertThat(allByUid.isEmpty(), is(false));
        assertThat(allByUid.get(0).getId(), is(order.get().getId()));
    }

    @Test
    public void should_return_payment_when_find_payment() throws Exception {
        Payment payment = orderRepository.getPayment(TestHelper.ORDER_ID);
        assertThat(payment.getOid(), is(TestHelper.ORDER_ID));
    }
}
