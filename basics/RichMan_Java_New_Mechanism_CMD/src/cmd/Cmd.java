package cmd;

import cmdType.CmdType;
import core.WithCommandCapability;

import java.util.List;

/**
 * Created by zyongliu on 25/11/16.
 */
public interface Cmd {

    List<CmdType> execute(WithCommandCapability player, List<CmdType> initialCmdType);

}
