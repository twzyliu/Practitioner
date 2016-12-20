package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import place.GiftRoom;

import java.util.List;

/**
 * Created by zyongliu on 26/11/16.
 */
public class ChoseGiftThree implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        player.setGodDays(GiftRoom.giftGodDays);
        return initialCmdType;
    }
}
