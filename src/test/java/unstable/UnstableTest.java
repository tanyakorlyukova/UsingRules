package unstable;

import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class UnstableTest {

    @Rule
    public TestRule runSeveralTimeRule = new RunSeveralTimesRule();

    private static int attempt = 0;

    @Test
    @Unstable(4)    //4 - number of attempts to restart test
    public void unstableTest() {
        attempt++;
        Assume.assumeTrue(attempt == 7);   //7 - required number of attempts to restart test
    }

}
