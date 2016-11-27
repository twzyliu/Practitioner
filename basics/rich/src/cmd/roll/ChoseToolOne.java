package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import item.Block;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ChoseToolOne implements Cmd{
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        Block block = player.getBlock();
        player.setPoint(player.getPoint() - block.getPoint());
        block.setNum(block.getNum() + 1);
        return asList();
    }
}
