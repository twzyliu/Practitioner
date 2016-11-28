package item;

import core.Player;

/**
 * Created by zyongliu on 27/11/16.
 */
public class Block extends Item{

    public Block() {
        super();
        point = 50;
    }

    @Override
    public int work(Player player, int target, int hospitalPosition) {
        player.getGameMap().getPlace(target).setTool(null);
        return target;
    }
}
