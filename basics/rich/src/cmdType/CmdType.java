package cmdType;

import cmd.Cmd;
import cmdType.roll.NoToBuyType;
import cmdType.roll.RollCmdType;
import cmdType.roll.YesToBuyType;
import cmdType.roll.YesToUpgradeType;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 25/11/16.
 */
public interface CmdType {
    String YES = "y";
    String NO = "n";

    List<CmdType> CMD_TYPES = asList(new RollCmdType(), new YesToBuyType(), new NoToBuyType(), new YesToUpgradeType());

    Optional<Cmd> parse(String cmd);
}
