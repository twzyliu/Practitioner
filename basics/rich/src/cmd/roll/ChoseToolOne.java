package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import item.Block;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ChoseToolOne implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        Block block = player.getBlock();
        if (player.getPoint() >= block.getPoint() && player.getToolsNum() < Player.MAX_ITEMS) {
            player.setPoint(player.getPoint() - block.getPoint());
            block.setNum(block.getNum() + 1);
        }
        return asList();
    }
}
