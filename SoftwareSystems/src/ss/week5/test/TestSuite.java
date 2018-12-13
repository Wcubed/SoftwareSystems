package ss.week5.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CompatibleTest.class, ComposedTest.class, InverseBijectionTest.class,
	InverseTest.class, IsOneOnOneTest.class, IsSurjectiveOnRangeTest.class })

public class TestSuite {
	// the class remains empty,
	// used only as a holder for the above annotations
}
