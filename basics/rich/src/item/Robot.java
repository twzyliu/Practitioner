package item;

import core.GameMap;
import core.Player;

/**
 * Created by zyongliu on 27/11/16.
 */
public class Robot extends Item {

    public static final int ROBOT_STEP = 10;

    public Robot() {
        super();
        point = 30;
    }

    @Override
    public void use(Player player) {
        if (num > 1) {
            num -= 1;
            GameMap gameMap = player.getGameMap();
            int position = player.getPosition();
            for (int i = 0; i < ROBOT_STEP; i++) {
                gameMap.getPlace(position + 1 + i).setTool(null);
            }
        }
    }
}
