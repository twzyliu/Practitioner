package com.thoughtworks.ketsu.domain;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zyongliu on 29/11/16.
 */
public interface Records {
    Record getRecord(String id);

    Record create(HashMap<String, Object> info);

    List<Record> getAllRecords();

}
