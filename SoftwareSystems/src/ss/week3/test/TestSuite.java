package ss.week3.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ConstantTest.class, ExponentTest.class, IdentityTest.class, LinearProductTest.class,
		ProductTest.class, SumTest.class, TimedPasswordTest.class })

public class TestSuite {
	// the class remains empty,
	// used only as a holder for the above annotations
}
