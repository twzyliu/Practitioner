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
        num -= 1;
        Place place = player.getPlace();
        place.setTool(this);
    }
}
