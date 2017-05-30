package de.nhamley.rock.paper.scissors.strategies;

import de.nhamley.rock.paper.scissors.models.ActionType;

/**
 * The Strategy that a player employs in a round of Rock Paper Scissors.
 * 
 * @author nhamley
 *
 */
public interface IStrategy {
    /**
     * Returns the choice for the next round.
     * 
     * @return the choice for the next round.
     */
    ActionType play();
}