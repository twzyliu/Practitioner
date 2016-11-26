package cmd;

import cmdType.CmdType;
import core.Player;

import java.util.List;

/**
 * Created by zyongliu on 25/11/16.
 */
public interface Cmd {

    List<CmdType> execute(Player player, List<CmdType> initialCmdType);

}
