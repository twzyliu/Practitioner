package place;

import cmdType.CmdType;
import core.Player;

import java.util.List;

/**
 * Created by zyongliu on 27/11/16.
 */
public class Prison extends Place {
    public static final int PRISON_DAYS = 2;

    @Override
    public List<CmdType> getAvailableCmd(Player player, List<CmdType> initialCmdType) {
        player.gotoPrison();
        return initialCmdType;
    }
}
