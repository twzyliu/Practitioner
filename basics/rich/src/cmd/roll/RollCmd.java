package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import place.Place;

import java.util.List;

/**
 * Created by zyongliu on 25/11/16.
 */
public class RollCmd implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        Place place = player.move();
        return place.getAvailableCmd(player, initialCmdType);
    }
}
