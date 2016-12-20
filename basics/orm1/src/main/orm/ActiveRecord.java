package main.orm;

import java.util.HashMap;

/**
 * Created by zyongliu on 20/12/16.
 */
public class ActiveRecord {
    private HashMap<String, Object> cache = new HashMap<>();

    private void init() {
        HashMap<String, Object> set = new HashMap<>();
        if (cache.containsKey(this.getClass().getName())) {
            return;
        }
    }
}
