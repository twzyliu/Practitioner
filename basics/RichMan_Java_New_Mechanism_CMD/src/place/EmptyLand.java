package place;

import cmdType.CmdType;
import cmdType.roll.NoToBuyType;
import cmdType.roll.NoToUpgradeType;
import cmdType.roll.YesToBuyType;
import cmdType.roll.YesToUpgradeType;
import core.Player;

import java.util.List;

import static java.lang.Math.pow;
import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 25/11/16.
 */
public class EmptyLand extends Place {
    public static final int MAX_LEVEL = 3;
    private Player owner = null;
    private int price;
    private int level = 0;

    public EmptyLand(int price) {
        this.price = price;
    }

    @Override
    public List<CmdType> getAvailableCmd(Player player, List<CmdType> initialCmdType) {
        if (getOwner() == null) {
            return asList(new YesToBuyType(), new NoToBuyType());
        } else if (player.equals(getOwner())) {
            return asList(new YesToUpgradeType(), new NoToUpgradeType());
        } else {
            player.setMoney(player.getMoney() - getBill());
            getOwner().setMoney(getOwner().getMoney() + getBill());
            return initialCmdType;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBill() {
        return (int) ((getPrice() / 2) * pow(2, level));
    }

    public int getSellPrice() {
        return 2 * price * (level + 1);
    }

    public void beSelled() {
        level = 0;
        owner = null;
    }
}
