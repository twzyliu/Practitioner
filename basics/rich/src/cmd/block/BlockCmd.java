package cmd.block;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import item.Block;

import java.util.List;

/**
 * Created by zyongliu on 27/11/16.
 */
public class BlockCmd implements Cmd {
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        Block block = player.getBlock();
        block.use(player);
        return initialCmdType;
    }
}
