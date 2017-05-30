package de.nhamley.test.rock.paper.scissors.model;

import org.junit.Assert;
import org.junit.Test;

import de.nhamley.rock.paper.scissors.models.ActionType;
import de.nhamley.rock.paper.scissors.strategies.AlwaysScissors;

public class StrategyTest {

    @Test
    public void test_alwaysScissors() {
        AlwaysScissors scissors = new AlwaysScissors();
        ActionType actual = scissors.play();
        Assert.assertEquals(ActionType.SCISSORS, actual);
    }

}
