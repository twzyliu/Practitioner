package core;

import place.Place;

/**
 * Created by zyongliu on 25/11/16.
 */
public interface GameMap {
    int move(int position);
    Place getPlace(int position);
}

