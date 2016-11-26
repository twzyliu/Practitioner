package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;

import java.util.List;

/**
 * Created by zyongliu on 25/11/16.
 */
public class NoToBuy implements Cmd {
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        return initialCmdType;
    }
}
