package place;

import cmdType.CmdType;
import cmdType.roll.NoToBuyType;
import cmdType.roll.YesToBuyTyp;
import core.Player;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 25/11/16.
 */
public class EmptyLand extends Place {
    private Player owner;

    @Override
    public List<CmdType> getAvailableCmd(Player player, List<CmdType> initialCmd) {
        if (getOwner() == null) {
            return asList(new YesToBuyTyp(), new NoToBuyType());
        } else {
            return initialCmd;
        }
    }

    public Player getOwner() {
        return owner;
    }
}
