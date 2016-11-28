package cmd;

import cmdType.CmdType;
import core.Player;

import java.util.List;

/**
 * Created by zyongliu on 28/11/16.
 */
public class HeloCmd implements Cmd{
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        return initialCmdType;
    }
}
