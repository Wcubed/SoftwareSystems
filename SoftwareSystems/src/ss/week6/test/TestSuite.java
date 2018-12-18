package ss.week6.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ArgumentExceptionTest.class, CardTest.class, DictionaryAttackTest.class,
		VoteMachineModelTest.class, ZipperTest.class })

public class TestSuite {
	// the class remains empty,
	// used only as a holder for the above annotations
}
