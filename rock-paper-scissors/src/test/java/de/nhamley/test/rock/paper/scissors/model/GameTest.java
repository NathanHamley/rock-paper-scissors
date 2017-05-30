package de.nhamley.test.rock.paper.scissors.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.nhamley.rock.paper.scissors.models.Game;
import de.nhamley.rock.paper.scissors.models.ActionType;
import de.nhamley.rock.paper.scissors.models.Player;
import de.nhamley.rock.paper.scissors.results.Result;
import de.nhamley.rock.paper.scissors.strategies.AlwaysScissors;

public class GameTest {

    private Game game;

    @Mock
    private Player player;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        game = new Game();
    }

    @Test
    public void test_noPlayers_100Rounds() {
        Result result = game.play(100);
        Assert.assertEquals(100, result.getTies());
    }

    @Test
    public void test_addPlayer() {
        game.addPlayer(player);
        Assert.assertEquals(1, game.getAmountOfPlayers());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addNullPlayer() {
        game.addPlayer(null);
        Assert.assertEquals(1, game.getAmountOfPlayers());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_addTwoEqualPlayers() {
        game.addPlayer(player);
        game.addPlayer(player);
        Assert.assertEquals(1, game.getAmountOfPlayers());
    }
    

    @Test
    public void test_removePlayer() {
        game.addPlayer(player);
        Assert.assertEquals(1, game.getAmountOfPlayers());
        game.removePlayer(player);
        Assert.assertEquals(0, game.getAmountOfPlayers());
    }
    
    @Test
    public void test_removeNullPlayer() {
        game.addPlayer(player);
        Assert.assertEquals(1, game.getAmountOfPlayers());
        game.removePlayer(null);
        Assert.assertEquals(1, game.getAmountOfPlayers());
    }

    @Test
    public void test_2Players_100Rounds() {
        Player playerA = new Player("Player A", new AlwaysScissors());
        Player playerB = new Player("Player B", () -> ActionType.PAPER);
        game.addPlayer(playerA);
        game.addPlayer(playerB);
        Result result = game.play(100);
        Assert.assertEquals(100, result.getTotalGamesPlayed());
        Assert.assertEquals(100, result.getWinsForPlayer(playerA));
        Assert.assertEquals(0, result.getWinsForPlayer(playerB));
        Assert.assertEquals(0, result.getTies());
    }

    @Test
    public void test_3Players_100Rounds_ObviousWinner() {
        Player playerA = new Player("Player A", new AlwaysScissors());
        Player playerB = new Player("Player B", () -> ActionType.PAPER);
        Player playerC = new Player("Player C", () -> ActionType.PAPER);
        game.addPlayer(playerA);
        game.addPlayer(playerB);
        game.addPlayer(playerC);
        Result result = game.play(100);
        Assert.assertEquals(100, result.getTotalGamesPlayed());
        Assert.assertEquals(100, result.getWinsForPlayer(playerA));
        Assert.assertEquals(0, result.getWinsForPlayer(playerB));
        Assert.assertEquals(0, result.getWinsForPlayer(playerC));
        Assert.assertEquals(0, result.getTies());
    }

    @Test
    public void test_3Players_100Rounds_2PlayersTie() {
        Player playerA = new Player("Player A", new AlwaysScissors());
        Player playerB = new Player("Player B", () -> ActionType.PAPER);
        Player playerC = new Player("Player C", new AlwaysScissors());
        game.addPlayer(playerA);
        game.addPlayer(playerB);
        game.addPlayer(playerC);
        Result result = game.play(100);
        Assert.assertEquals(100, result.getTotalGamesPlayed());
        Assert.assertEquals(0, result.getWinsForPlayer(playerA));
        Assert.assertEquals(0, result.getWinsForPlayer(playerB));
        Assert.assertEquals(0, result.getWinsForPlayer(playerC));
        Assert.assertEquals(100, result.getTies());
    }

}
