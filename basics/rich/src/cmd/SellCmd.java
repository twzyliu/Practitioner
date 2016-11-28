package cmd;

import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import place.EmptyLand;
import place.Place;

import java.util.List;

/**
 * Created by zyongliu on 28/11/16.
 */
public class SellCmd implements Cmd {
    private int position = 0;

    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        Place place = player.getGameMap().getPlace(position);
        if (place instanceof EmptyLand && player.equals(((EmptyLand) place).getOwner())) {
            player.setMoney(player.getMoney() + ((EmptyLand) place).getSellPrice());
            player.getLands().remove(place);
            ((EmptyLand) place).beSelled();
        }
        return initialCmdType;
    }

    public Cmd setPosition(int position) {
        this.position = position;
        return this;
    }
}
