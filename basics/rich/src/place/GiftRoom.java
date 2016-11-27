package place;

import cmdType.CmdType;
import cmdType.roll.ChoseGiftOneType;
import cmdType.roll.ChoseGiftThreeType;
import cmdType.roll.ChoseGiftTwoType;
import core.Player;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 26/11/16.
 */
public class GiftRoom extends Place {
    public static final int giftMoney = 2000;
    public static final int giftPoint = 200;
    public static final int giftGodDays = 5;

    @Override
    public List<CmdType> getAvailableCmd(Player player, List<CmdType> initialCmdType) {
        return asList(new ChoseGiftOneType(),new ChoseGiftTwoType(),new ChoseGiftThreeType());
    }

}
