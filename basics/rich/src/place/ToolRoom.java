package place;

import cmdType.CmdType;
import cmdType.roll.ChoseToolExitType;
import cmdType.roll.ChoseToolOneType;
import cmdType.roll.ChoseToolThreeType;
import cmdType.roll.ChoseToolTwoType;
import core.Player;
import item.Item;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ToolRoom extends Place {
    @Override
    public List<CmdType> getAvailableCmd(Player player, List<CmdType> initialCmdType) {
        if (player.getPoint() < Item.CHEAPEST) {
            return initialCmdType;
        } else {
            return asList(new ChoseToolOneType(),new ChoseToolTwoType(),new ChoseToolThreeType(),new ChoseToolExitType());
        }
    }
}
