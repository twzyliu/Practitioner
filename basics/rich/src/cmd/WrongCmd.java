package cmd;

import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import place.GiftRoom;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 26/11/16.
 */
public class WrongCmd implements Cmd {

    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        if (player.getPlace() instanceof GiftRoom) {
            return initialCmdType;
        } else {
            return asList();
        }
    }
}
