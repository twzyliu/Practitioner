package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Contract;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;

import java.util.Map;

import static com.thoughtworks.ketsu.support.TestHelper.ID;
import static com.thoughtworks.ketsu.support.TestHelper.ROAMING_RATES;
import static com.thoughtworks.ketsu.support.TestHelper.otherCard;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 29/11/16.
 */
@RunWith(ApiTestRunner.class)
public class ContractApiTest extends ApiSupport {
    private Card card;
    private Contract contract;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        card = new Card(ID, TestHelper.NUMBER);
        contract = new Contract(card);
        contract.setRoamingRates(TestHelper.ROAMING_RATES);
        card.setContract(contract);
        when(cards.getCard(ID)).thenReturn(card);
        when(currentCard.getCurrentCard()).thenReturn(card);
    }

    @Test
    public void should_return_200_when_get_contract_info() throws Exception {
        Response response = get("/cards/" + ID + "/contract");
        Map map = response.readEntity(Map.class);

        assertThat(response.getStatus(), is(200));
        assertThat(map.getOrDefault("roamingRates", ""), is(ROAMING_RATES));
        assertThat(map.getOrDefault("url", "").toString().contains(ID), is(true));
    }

    @Test
    public void should_return_404_when_get_contract_fail() throws Exception {
        Response response = get("/cards/a/contract");

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_404_when_get_other_contract() throws Exception {
        when(currentCard.getCurrentCard()).thenReturn(otherCard);
        Response response = get("/cards/" + ID + "/contract");

        assertThat(response.getStatus(), is(404));
    }
}
