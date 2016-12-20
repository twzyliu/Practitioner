package place;

import cmdType.CmdType;
import core.Player;

import java.util.List;

/**
 * Created by zyongliu on 27/11/16.
 */
public class Mine extends Place {
    private int point;

    public Mine(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public List<CmdType> getAvailableCmd(Player player, List<CmdType> initialCmdType) {
        player.setPoint(player.getPoint() + getPoint());
        return initialCmdType;
    }
}
