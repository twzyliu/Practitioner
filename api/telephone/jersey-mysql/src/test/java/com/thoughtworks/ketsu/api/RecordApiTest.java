package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Record;
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
import static com.thoughtworks.ketsu.support.TestHelper.otherCard;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 29/11/16.
 */
@RunWith(ApiTestRunner.class)
public class RecordApiTest extends ApiSupport {
    private Card card;
    private Record record;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        card = new Card(ID, TestHelper.NUMBER);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", "100");
        record = new Record(hashMap);
        record.setCard(card);
        List<Record> recordList = asList(record, record, record);
        when(cards.getCard(ID)).thenReturn(card);
        when(currentCard.getCurrentCard()).thenReturn(card);
        when(records.getRecord(anyString())).thenReturn(record);
        when(records.create(any())).thenReturn(record);
        when(records.getAllRecords()).thenReturn(recordList);
    }

    @Test
    public void should_return_201_when_card_create_record() throws Exception {
        Response response = post("/cards/" + ID + "/records", new HashMap<>());

        assertThat(response.getStatus(), is(201));
        assertThat(response.getLocation().toString().contains(record.getId()), is(true));
    }

    @Test
    public void should_return_400_when_create_record_fail() throws Exception {
        when(records.create(any())).thenReturn(null);
        Response response = post("/cards/" + ID + "/records", new HashMap<>());

        assertThat(response.getStatus(), is(400));
    }

    @Test
    public void should_return_404_when_create_others_record() throws Exception {
        when(currentCard.getCurrentCard()).thenReturn(otherCard);

        Response response = post("/cards/" + ID + "/records", new HashMap<>());

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_200_when_get_records() throws Exception {
        Response response = get("/cards/" + ID + "/records");

        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void shoukd_return_404_when_get_records_fails() throws Exception {
        when(records.getAllRecords()).thenReturn(asList());
        Response response = get("/cards/" + ID + "/records");

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_404_when_get_others_records() throws Exception {
        when(currentCard.getCurrentCard()).thenReturn(otherCard);
        Response response = get("/cards/" + ID + "/records");

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_200_when_get_record() throws Exception {
        Response response = get("/cards/" + ID + "/records/" + record.getId());

        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void should_return_404_when_get_recoed_fail() throws Exception {
        when(records.getRecord(anyString())).thenReturn(null);
        Response response = get("/cards/" + ID + "/records/" + record.getId());

        assertThat(response.getStatus(), is(404));
    }
}
