package cmd;

import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import item.Bomb;

import java.util.List;

/**
 * Created by zyongliu on 27/11/16.
 */
public class BombCmd implements Cmd {
    private int step = 0;

    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        Bomb bomb = player.getBomb();
        bomb.use(player, step);
        return initialCmdType;
    }

    public Cmd setStep(int step) {
        this.step = step;
        return this;
    }
}
