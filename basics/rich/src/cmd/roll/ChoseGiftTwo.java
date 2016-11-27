package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import place.GiftRoom;

import java.util.List;

/**
 * Created by zyongliu on 26/11/16.
 */
public class ChoseGiftTwo implements Cmd {
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        player.setPoint(player.getPoint() + GiftRoom.giftPoint);
        return initialCmdType;
    }
}
