package core;

import place.Place;

import java.util.List;

/**
 * Created by zyongliu on 25/11/16.
 */
public class GameMap {
    private List<Place> places;

    public GameMap(List<Place> places) {
        this.places = places;
    }

    public int move(int position) {
        return 0;
    }

    public Place getPlace(int position) {
        return places.get(position % places.size());
    }
}

