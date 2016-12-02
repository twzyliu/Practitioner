package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Bill;
import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.thoughtworks.ketsu.support.TestHelper.ID;
import static com.thoughtworks.ketsu.support.TestHelper.otherCard;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 01/12/16.
 */
@RunWith(ApiTestRunner.class)
public class BillApiTest extends ApiSupport{
    
    private Card card;
    private List<Bill> billList;
    private Bill bill;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        card = new Card(ID, TestHelper.NUMBER);
        bill = new Bill(ID, card);
        billList = asList(bill, bill, bill);
        when(cards.getCard(ID)).thenReturn(card);
        when(currentCard.getCurrentCard()).thenReturn(card);
        when(cards.getAllBills(anyString())).thenReturn(billList);
        when(cards.getBill(anyString())).thenReturn(bill);
    }

    @Test
    public void should_return_200_when_get_bills() throws Exception {
        Response response = get("/cards/" + ID + "/bills");
        List<HashMap> billLists = response.readEntity(List.class);

        assertThat(response.getStatus(), is(200));
        assertThat(billLists.size(), is(billLists.size()));
        assertThat(billLists.get(0).getOrDefault("id",""), is(ID));
    }

    @Test
    public void should_return_404_when_get_bills_fails() throws Exception {
        when(cards.getAllBills(anyString())).thenReturn(asList());
        Response response = get("/cards/" + ID + "/bills");

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_404_when_get_others_bills() throws Exception {
        when(currentCard.getCurrentCard()).thenReturn(otherCard);
        Response response = get("/cards/" + ID + "/bills");

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_200_when_get_bill() throws Exception {
        Response response = get("/cards/" + ID + "/bills/" + bill.getId());
        Map map = response.readEntity(Map.class);

        assertThat(response.getStatus(), is(200));
        assertThat(map.getOrDefault("id", ""), is(bill.getId()));
        assertThat(map.getOrDefault("url", "").toString().contains(bill.getId()), is(true));
    }

    @Test
    public void should_return_404_when_get_bill_fail() throws Exception {
        when(cards.getBill(anyString())).thenReturn(null);
        Response response = get("/cards/" + ID + "/bills/" + bill.getId());

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_404_when_get_others_bill() throws Exception {
        when(currentCard.getCurrentCard()).thenReturn(otherCard);
        Response response = get("/cards/" + ID + "/bills/" + bill.getId());

        assertThat(response.getStatus(), is(404));
    }
}











