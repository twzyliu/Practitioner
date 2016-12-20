package cmd;

import cmdType.CmdType;
import cmdType.InitPlayerCmdType;
import core.Game;
import core.WithCommandCapability;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 28/11/16.
 */
public class InitMoneyCmd implements Cmd {

    private int initMoney = 0;

    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Game game = (Game) withCommandCapability;
        game.setInitMoney(initMoney);
        return asList(new InitPlayerCmdType());
    }

    public Cmd setInitMoney(int initMoney) {
        this.initMoney = initMoney;
        return this;
    }
}
