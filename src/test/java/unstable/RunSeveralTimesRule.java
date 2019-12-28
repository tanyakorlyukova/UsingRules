package unstable;

import org.junit.Assert;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunSeveralTimesRule implements TestRule {

    @Override
    public Statement apply(final Statement base, Description description) {

        return new RunSeveralTimeStatement(base, description);
    }

    public class RunSeveralTimeStatement extends Statement {

        private final Statement base;
        private Description description;

        public RunSeveralTimeStatement(Statement base, Description desc) {
            this.base = base;
            this.description = desc;
        }


        @Override
        public void evaluate() throws Throwable {
            Unstable unstable = description.getAnnotation(Unstable.class);
            if (unstable != null) {
                for (int attempt = 1; attempt <= unstable.value(); attempt++) {
                    try {
                        base.evaluate();
                        System.out.println("Test passed on attempt: " + attempt);
                        break;
                    } catch (Exception error) {
                        if (attempt == unstable.value()) {
                            Assert.fail("Test failed on last attempt: " + attempt);
                        }
                        System.out.println("Failed on attempt: " + attempt);
                    }
                }
            }
        }
    }

}
