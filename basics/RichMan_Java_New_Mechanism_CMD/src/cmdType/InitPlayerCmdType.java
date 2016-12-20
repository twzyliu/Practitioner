package cmdType;

import cmd.Cmd;
import cmd.InitMoneyCmd;
import cmd.InitPlayerCmd;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by zyongliu on 28/11/16.
 */
public class InitPlayerCmdType implements CmdType {
    @Override
    public Optional<Cmd> parse(String cmd) {
        try {
            List<Integer> playerNums = Arrays.stream(cmd.split("")).map(Integer::parseInt).collect(Collectors.toList());
            if (playerNums.size() > 1 && playerNums.size() < 5) {
                return Optional.of(new InitPlayerCmd().setPlayerNums(playerNums));
            } else {
                return Optional.of(new InitMoneyCmd());
            }
        } catch (Exception e) {
            return Optional.of(new InitMoneyCmd());
        }
    }
}
