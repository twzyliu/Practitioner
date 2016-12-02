package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Balance;
import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.Map;

import static com.thoughtworks.ketsu.support.TestHelper.ID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 02/12/16.
 */
@RunWith(ApiTestRunner.class)
public class BalanceApiTest extends ApiSupport{
    private Card card;
    private Balance balance;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        card = new Card(ID, TestHelper.NUMBER);
        balance = new Balance(ID, card);
        card.setBalance(balance);
        when(cards.getCard(ID)).thenReturn(card);
        when(currentCard.getCurrentCard()).thenReturn(card);
    }

    @Test
    public void should_return_200_when_get_balance() throws Exception {
        Response response = get("/cards/" + ID + "/balance");
        Map map = response.readEntity(Map.class);

        assertThat(response.getStatus(), is(200));
        assertThat(map.getOrDefault("id", ""), is(balance.getId()));
        assertThat(map.getOrDefault("url", "").toString().contains(ID), is(true));
    }

    @Test
    public void should_return_404_when_get_balance_fail() throws Exception {
        card.setBalance(null);
        Response response = get("/cards/" + ID + "/balance");

        assertThat(response.getStatus(), is(404));
    }
}
