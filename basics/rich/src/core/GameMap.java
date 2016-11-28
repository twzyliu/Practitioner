package core;

import item.Item;
import place.Hospital;
import place.Place;

import java.util.List;

import static java.lang.Math.random;

/**
 * Created by zyongliu on 25/11/16.
 */
public class GameMap {
    private List<Place> places;

    public GameMap(List<Place> places) {
        this.places = places;
    }

    public int move(Player player, int position) {
        int target = position;
        int step = (int) (random() * 6 + 1);
        for (int i = 0; i < step; i++) {
            target = (position + i + 1) % places.size();
            Item tool = getPlace(target).getTool();
            if (tool != null) {
                return tool.work(player, target, getHospitalPosition());
            }
        }
        return target;
    }

    public Place getPlace(int position) {
        return places.get(position % places.size());
    }

    public int getHospitalPosition() {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) instanceof Hospital) {
                return i;
            }
        }
        return 0;
    }
}

