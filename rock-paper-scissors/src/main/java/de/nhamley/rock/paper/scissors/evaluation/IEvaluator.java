package de.nhamley.rock.paper.scissors.evaluation;

import de.nhamley.rock.paper.scissors.models.ActionType;

public interface IEvaluator {

    /**
     * Evaluates the result of the two play types and returns whether player 1 wins, player 2 wins or a tie has occurred.
     * 
     * @param player1
     *            the play that player 1 made.
     * @param player2
     *            the play that player 2 made.
     * @return the {@link ResultType}, depending on who won.
     */
    ResultType evalResult(ActionType player1, ActionType player2);

}