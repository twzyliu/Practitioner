package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.WithCommandCapability;

import java.util.List;

/**
 * Created by zyongliu on 26/11/16.
 */
public class NoToUpgrade implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability player, List<CmdType> initialCmdType) {
        return initialCmdType;
    }
}
