package core;

import cmd.Cmd;
import cmdType.CmdType;
import place.Place;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 25/11/16.
 */
public class Player {

    private List<CmdType> availableCmd;
    private List<CmdType> initialCmd;
    private GameMap gameMap;
    private int position = 0;

    public Player(GameMap gameMap, CmdType... cmdTypes) {
        this.initialCmd = asList(cmdTypes);
        this.availableCmd = this.initialCmd;
        this.gameMap = gameMap;
    }

    public Optional<Cmd> getAvailableCmd(String cmd) {
        return availableCmd.stream().map(cmdType -> cmdType.parse(cmd)).findFirst().get();
    }

    public void execute(Optional<Cmd> rich) {
        this.availableCmd = rich.get().execute(this, initialCmd);
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Place move() {
        position = getGameMap().move(position);
        return getPlace();
    }

    public Place getPlace() {
        return getGameMap().getPlace(position);
    }
}
