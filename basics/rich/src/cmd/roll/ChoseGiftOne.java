package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import place.GiftRoom;

import java.util.List;

/**
 * Created by zyongliu on 26/11/16.
 */
public class ChoseGiftOne implements Cmd {
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        GiftRoom giftRoom = (GiftRoom) player.getPlace();
        player.setMoney(player.getMoney() + giftRoom.getGiftMoney());
        return initialCmdType;
    }
}
