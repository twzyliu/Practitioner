package cmdType;

import cmd.Cmd;
import cmdType.roll.*;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 25/11/16.
 */
public interface CmdType {
    String YES = "y";
    String NO = "n";
    String CHOSE_ONE = "1";
    String CHOSE_TWO = "2";
    String CHOSE_THREE = "3";
    String EXIT = "f";

    List<CmdType> CMD_TYPES = asList(
            new RollCmdType(),
            new YesToBuyType(),
            new NoToBuyType(),
            new YesToUpgradeType(),
            new NoToUpgradeType(),
            new ChoseGiftOneType(),
            new ChoseGiftTwoType(),
            new ChoseGiftThreeType(),
            new ChoseToolOneType(),
            new ChoseToolTwoType(),
            new ChoseToolThreeType(),
            new ChoseToolExitType(),
            new BlockCmdType(),
            new BombCmdType(),
            new RobotCmdType(),
            new SellCmdType(),
            new SelltoolCmdType()
    );


    Optional<Cmd> parse(String cmd);
}
