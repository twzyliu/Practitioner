package cmd;

import cmdType.CmdType;
import cmdType.RichCmdType;
import core.Game;
import core.WithCommandCapability;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 28/11/16.
 */
public class InitPlayerCmd implements Cmd {
    private List<Integer> playerNums;

    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Game game = (Game) withCommandCapability;
        game.setPlayerNums(playerNums);
        return asList(new RichCmdType());
    }

    public Cmd setPlayerNums(List<Integer> playerNums) {
        this.playerNums = playerNums;
        return this;
    }
}
