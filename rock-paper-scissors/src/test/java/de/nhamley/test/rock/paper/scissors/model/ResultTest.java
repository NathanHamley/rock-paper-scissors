package de.nhamley.test.rock.paper.scissors.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import de.nhamley.rock.paper.scissors.models.ActionType;
import de.nhamley.rock.paper.scissors.models.Player;
import de.nhamley.rock.paper.scissors.results.Result;

public class ResultTest {
    @Mock
    private Player player;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_addResult_MockPlayer() {
        Result result = new Result();
        result.addResult(player);
        Assert.assertEquals(1, result.getTotalGamesPlayed());
        Assert.assertEquals(1, result.getWinsForPlayer(player));
    }

    @Test
    public void test_addResult_Null() {
        Result result = new Result();
        result.addResult(null);
        Assert.assertEquals(1, result.getTotalGamesPlayed());
        Assert.assertEquals(1, result.getTies());
    }

    @Test
    public void test_winsForUnknownPlayer() {
        Result result = new Result();
        result.addResult(null);
        Assert.assertEquals(1, result.getTotalGamesPlayed());
        Assert.assertEquals(0, result.getWinsForPlayer(player));
    }

    @Test
    public void test_outputPlayerWins() {
        Result result = new Result();
        Mockito.when(player.getName()).thenReturn("Player A");
        Mockito.when(player.getPlay()).thenReturn(ActionType.PAPER);
        result.addResult(player);
        String actual = result.toString();
        String expected = "Player A wins 1 of 1 games\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_outputTies() {
        Result result = new Result();
        Mockito.when(player.getName()).thenReturn("Player A");
        Mockito.when(player.getPlay()).thenReturn(ActionType.PAPER);
        result.addResult(null);
        String actual = result.toString();
        String expected = "Tie: 1 of 1 games\n";
        Assert.assertEquals(expected, actual);
    }

}