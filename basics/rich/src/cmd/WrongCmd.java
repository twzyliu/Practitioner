package cmd;

import cmdType.CmdType;
import core.Player;
import place.GiftRoom;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 26/11/16.
 */
public class WrongCmd implements Cmd {

    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        if (player.getPlace() instanceof GiftRoom) {
            return initialCmdType;
        } else {
            return asList();
        }
    }
}
