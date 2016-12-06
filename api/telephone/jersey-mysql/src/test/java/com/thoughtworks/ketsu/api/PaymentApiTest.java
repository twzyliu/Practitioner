package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Payment;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

import static com.thoughtworks.ketsu.support.TestHelper.ID;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 06/12/16.
 */
@RunWith(ApiTestRunner.class)
public class PaymentApiTest extends ApiSupport {
    private Card card;
    private Payment payment;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        card = new Card(ID, TestHelper.NUMBER);
        payment = new Payment(ID, card);
        List<Payment> payments = asList(payment, payment, payment);
        when(cards.getCard(ID)).thenReturn(card);
        when(currentCard.getCurrentCard()).thenReturn(card);
        when(cards.createPayment(any(), any())).thenReturn(payment);
        when(cards.getAllPayments()).thenReturn(payments);
    }

    @Test
    public void should_return_201_when_create_payment_success() throws Exception {
        Response response = post("/cards/" + ID + "/payments", new HashMap<>());

        assertThat(response.getStatus(), is(201));
        assertThat(response.getLocation().toString().contains(payment.getId()), is(true));
    }

    @Test
    public void should_return_400_when_create_payment_fail() throws Exception {
        when(cards.createPayment(any(), any())).thenReturn(null);
        Response response = post("/cards/" + ID + "/payments", new HashMap<>());

        assertThat(response.getStatus(), is(400));
    }

    @Test
    public void should_return_200_when_get_payments() throws Exception {
        Response response = get("/cards/" + ID + "/payments");
        List<HashMap<String,Object>> list = response.readEntity(List.class);

        assertThat(response.getStatus(), is(200));
        assertThat(list.get(0).getOrDefault("id", "").toString(), is(payment.getId()));
        assertThat(list.get(0).getOrDefault("url", "").toString().contains(payment.getId()),is(true));
    }

    @Test
    public void should_return_404_when_get_payments_fail() throws Exception {
        when(cards.getAllPayments()).thenReturn(null);
        Response response = get("/cards/" + ID + "/payments");

        assertThat(response.getStatus(), is(404));
    }
}
