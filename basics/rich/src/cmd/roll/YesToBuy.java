package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import place.EmptyLand;

import java.util.List;

/**
 * Created by zyongliu on 25/11/16.
 */
public class YesToBuy implements Cmd {
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmd) {
        EmptyLand emptyLand = (EmptyLand) player.getPlace();
        player.setMoney(player.getMoney() - emptyLand.getPrice());
        player.getLands().add(emptyLand);
        emptyLand.setOwner(player);
        return null;
    }
}
