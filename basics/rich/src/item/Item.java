package item;

import core.Player;
import place.Place;

/**
 * Created by zyongliu on 27/11/16.
 */
public class Item {
    public static final int CHEAPEST = 30;
    protected int point = 0;
    protected int num = 0;

    public Item() {
    }

    public int getPoint() {
        return point;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void use(Player player) {
        Place place = player.getPlace();
        if (num > 1 && place.getPlayer() == null && place.getTool() == null) {
            num -= 1;
            place.setTool(this);
        }
    }
}
