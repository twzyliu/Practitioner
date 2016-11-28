package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import place.EmptyLand;

import java.util.List;

/**
 * Created by zyongliu on 26/11/16.
 */
public class YesToUpgrade implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        EmptyLand emptyLand = (EmptyLand) player.getPlace();
        int money = player.getMoney();
        int price = emptyLand.getPrice();
        int level = emptyLand.getLevel();
        if (money >= price && level < EmptyLand.MAX_LEVEL) {
            player.setMoney(money - price);
            emptyLand.setLevel(level + 1);
        }
        return initialCmdType;
    }
}
