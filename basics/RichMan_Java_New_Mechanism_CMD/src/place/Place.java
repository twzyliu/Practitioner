package place;

import cmdType.CmdType;
import core.Player;
import item.Item;

import java.util.List;

/**
 * Created by zyongliu on 25/11/16.
 */
public class Place {
    private Item tool;
    private Player player;

    public List<CmdType> getAvailableCmd(Player player, List<CmdType> initialCmdType) {
        return initialCmdType;
    }

    public Item getTool() {
        return tool;
    }

    public void setTool(Item tool) {
        this.tool = tool;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
