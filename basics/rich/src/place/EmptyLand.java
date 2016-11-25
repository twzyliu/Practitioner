package place;

import cmdType.CmdType;
import cmdType.roll.NoToBuyType;
import cmdType.roll.YesToBuyType;
import core.Player;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 25/11/16.
 */
public class EmptyLand extends Place {
    private Player owner = null;
    private int price;

    public EmptyLand(int price) {
        this.price = price;
    }

    @Override
    public List<CmdType> getAvailableCmd(Player player, List<CmdType> initialCmd) {
        if (getOwner() == null) {
            return asList(new YesToBuyType(), new NoToBuyType());
        } else {
            return initialCmd;
        }
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }
}
