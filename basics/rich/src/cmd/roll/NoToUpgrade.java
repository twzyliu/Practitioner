package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;

import java.util.List;

/**
 * Created by zyongliu on 26/11/16.
 */
public class NoToUpgrade implements Cmd {
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        return initialCmdType;
    }
}
