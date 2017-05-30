package de.nhamley.rock.paper.scissors.strategies;

import de.nhamley.rock.paper.scissors.models.ActionType;

/**
 * A Strategy, where the player always chooses Scissors.
 * 
 * @author nhamley
 *
 */
public class AlwaysScissors implements IStrategy {

    @Override
    public ActionType play() {
        return ActionType.SCISSORS;
    }

}
