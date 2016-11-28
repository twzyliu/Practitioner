package cmd;

import cmdType.CmdType;
import core.WithCommandCapability;

import java.util.List;

/**
 * Created by zyongliu on 28/11/16.
 */
public class InitPlayerCmd implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability player, List<CmdType> initialCmdType) {
        return null;
    }
}
