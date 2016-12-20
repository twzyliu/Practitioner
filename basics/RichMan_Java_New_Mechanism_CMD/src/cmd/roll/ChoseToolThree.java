package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import item.Bomb;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ChoseToolThree implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        Bomb bomb = player.getBomb();
        if (player.getPoint() >= bomb.getPoint() && player.getToolsNum() < Player.MAX_ITEMS) {
            player.setPoint(player.getPoint() - bomb.getPoint());
            bomb.setNum(bomb.getNum() + 1);
        }
        return asList();
    }
}
