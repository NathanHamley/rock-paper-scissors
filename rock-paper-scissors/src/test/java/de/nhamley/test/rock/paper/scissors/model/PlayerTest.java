package de.nhamley.test.rock.paper.scissors.model;

import org.junit.Assert;
import org.junit.Test;

import de.nhamley.rock.paper.scissors.models.Player;
import de.nhamley.rock.paper.scissors.strategies.AlwaysScissors;
import de.nhamley.rock.paper.scissors.strategies.RandomPlayType;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void test_noStrategie() {
        Player player = new Player("No_Strategie", null);
        player.getPlay();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_noName() {
        Player player = new Player(null, new AlwaysScissors());
        player.getPlay();
    }

    @Test
    public void test_equalIfNameIsEqual() {
        Player player1 = new Player("Player1", new AlwaysScissors());
        Player player2 = new Player("Player1", new RandomPlayType());
        Assert.assertTrue(player1.equals(player2));
    }
}