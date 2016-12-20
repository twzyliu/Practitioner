package cmd;

import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import item.Item;

import java.util.List;

/**
 * Created by zyongliu on 28/11/16.
 */
public class SelltoolCmd implements Cmd {
    private int toolNum = 0;

    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        Item tool = player.getTool(toolNum);
        int num = tool.getNum();
        if (num > 1) {
            tool.setNum(num - 1);
            player.setPoint(player.getPoint() + tool.getPoint());
        }
        return initialCmdType;
    }

    public Cmd setToolNum(int toolNum) {
        this.toolNum = toolNum;
        return this;
    }
}
