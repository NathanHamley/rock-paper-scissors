package de.nhamley.rock.paper.scissors.strategies;

import java.util.Random;

import de.nhamley.rock.paper.scissors.models.ActionType;

/**
 * A Strategy, where the player returns a random choice each round.
 * 
 * @author nhamley
 *
 */
public class RandomPlayType implements IStrategy {
    Random random = new Random();

    ActionType[] values = ActionType.values();

    @Override
    public ActionType play() {
        return values[random.nextInt(3)];
    }

}
