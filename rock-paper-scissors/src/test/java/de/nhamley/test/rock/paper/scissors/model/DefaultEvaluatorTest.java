package de.nhamley.test.rock.paper.scissors.model;

import org.junit.Assert;
import org.junit.Test;

import de.nhamley.rock.paper.scissors.evaluation.DefaultEvaluator;
import de.nhamley.rock.paper.scissors.evaluation.ResultType;
import de.nhamley.rock.paper.scissors.models.ActionType;

public class DefaultEvaluatorTest {

    @Test
    public void test_rockBeatsScissors() {
        DefaultEvaluator evaluator = new DefaultEvaluator();
        ResultType type = evaluator.evalResult(ActionType.ROCK, ActionType.SCISSORS);
        Assert.assertTrue(type == ResultType.PLAYER_1);
    }

    @Test
    public void test_scissorsBeatsPaper() {
        DefaultEvaluator evaluator = new DefaultEvaluator();
        ResultType type = evaluator.evalResult(ActionType.PAPER, ActionType.SCISSORS);
        Assert.assertTrue(type == ResultType.PLAYER_2);
    }

    @Test
    public void test_paperBeatsRock() {
        DefaultEvaluator evaluator = new DefaultEvaluator();
        ResultType type = evaluator.evalResult(ActionType.PAPER, ActionType.ROCK);
        Assert.assertTrue(type == ResultType.PLAYER_1);
    }

    @Test
    public void test_rockTie() {
        DefaultEvaluator evaluator = new DefaultEvaluator();
        ResultType type = evaluator.evalResult(ActionType.ROCK, ActionType.ROCK);
        Assert.assertTrue(type == ResultType.TIE);
    }

    @Test
    public void test_paperTie() {
        DefaultEvaluator evaluator = new DefaultEvaluator();
        ResultType type = evaluator.evalResult(ActionType.PAPER, ActionType.PAPER);
        Assert.assertTrue(type == ResultType.TIE);
    }

    @Test
    public void test_scissorsTie() {
        DefaultEvaluator evaluator = new DefaultEvaluator();
        ResultType type = evaluator.evalResult(ActionType.SCISSORS, ActionType.SCISSORS);
        Assert.assertTrue(type == ResultType.TIE);
    }
}
