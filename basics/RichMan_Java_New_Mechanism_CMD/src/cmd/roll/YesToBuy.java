package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import place.EmptyLand;

import java.util.List;

/**
 * Created by zyongliu on 25/11/16.
 */
public class YesToBuy implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        EmptyLand emptyLand = (EmptyLand) player.getPlace();
        int money = player.getMoney();
        int price = emptyLand.getPrice();
        if (money >= price) {
            player.setMoney(money - price);
            player.getLands().add(emptyLand);
            emptyLand.setOwner(player);
        }
        return initialCmdType;
    }
}
