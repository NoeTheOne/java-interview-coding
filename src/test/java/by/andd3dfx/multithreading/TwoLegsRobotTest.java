package by.andd3dfx.multithreading;

import org.awaitility.Durations;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class TwoLegsRobotTest {

    private Map<Boolean, String> EXPECTED_STRING = Map.of(
            false, "left steps",
            true, "right steps"
    );

    private TwoLegsRobot robot;

    @Before
    public void setUp() throws Exception {
        robot = new TwoLegsRobot();
    }

    @Test
    public void testLogsOrder() {
        robot.start();
        await()
                .atMost(Durations.ONE_SECOND)
                .pollInterval(50, TimeUnit.MILLISECONDS)
                .until(() -> robot.getLogs().split("!").length > 10);   // At least 10 steps

        checkLogs(robot.getLogs());
    }

    private void checkLogs(String logs) {
        String[] lines = logs.split("!");
        assertThat(lines.length, greaterThan(10));

        var index = false;
        for (var line : lines) {
            assertThat(line, is(EXPECTED_STRING.get(index)));
            index = !index;
        }
    }
}
