package cmd;

import cmdType.CmdType;
import core.Player;
import item.Bomb;

import java.util.List;

/**
 * Created by zyongliu on 27/11/16.
 */
public class BombCmd implements Cmd {
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        Bomb bomb = player.getBomb();
        bomb.use(player);
        return initialCmdType;
    }
}
