import cmd.Cmd;
import cmd.roll.YesToBuy;
import cmdType.roll.RollCmdType;
import core.GameMap;
import core.Player;
import org.junit.Before;
import org.junit.Test;
import place.EmptyLand;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 25/11/16.
 */
public class RollCmdEmptyLandTest {

    private RollCmdType rollCmdType;
    private Player player;
    private Cmd yesToBuy;
    private GameMap gameMap;

    @Before
    public void setUp() throws Exception {
        gameMap = mock(GameMap.class);
        rollCmdType = new RollCmdType();
        player = new Player(gameMap, rollCmdType);
        yesToBuy = new YesToBuy();
        EmptyLand emptyLand = new EmptyLand();
        when(gameMap.getPlace(anyInt())).thenReturn(emptyLand);
    }

    @Test
    public void should_return_available_cmds_after_roll_to_emptyland() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> yes = player.getAvailableCmd(TestHelper.YES);

        assertThat(yes.get(), is(yesToBuy));
    }
}
