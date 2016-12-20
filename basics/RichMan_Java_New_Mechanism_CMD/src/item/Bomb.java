package item;

import core.GameMap;
import core.Player;
import place.Place;

/**
 * Created by zyongliu on 27/11/16.
 */
public class Bomb extends Item{

    public Bomb() {
        super();
        point = 50;
    }

    @Override
    public int work(Player player, int target, int hospitalPosition) {
        GameMap gameMap = player.getGameMap();
        Place place = gameMap.getPlace(target);
        place.setTool(null);
        player.gotoHospital();
        return hospitalPosition;
    }
}
