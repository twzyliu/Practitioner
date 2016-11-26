package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import place.Place;

import java.util.List;

/**
 * Created by zyongliu on 25/11/16.
 */
public class RollCmd implements Cmd {
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        Place place = player.move();
        return place.getAvailableCmd(player, initialCmdType);
    }
}
