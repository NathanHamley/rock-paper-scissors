package de.nhamley.test.rock.paper.scissors.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    DefaultEvaluatorTest.class, GameTest.class, PlayerTest.class, ResultTest.class, StrategyTest.class
})

public class AllTests {

}
