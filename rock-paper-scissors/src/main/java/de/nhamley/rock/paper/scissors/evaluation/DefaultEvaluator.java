package de.nhamley.rock.paper.scissors.evaluation;

import de.nhamley.rock.paper.scissors.models.ActionType;

/**
 * Default implementation of the {@link IEvaluator} interface. Rock beats Scissors, Scissors beats Paper and Paper beats Rock. If both
 * players choose the same action, it is a tie.
 * 
 * @author nhamley
 *
 */
public class DefaultEvaluator implements IEvaluator {

    @Override
    public ResultType evalResult(ActionType player1, ActionType player2) {
        switch (player1) {
        case PAPER:
            if (player2 == ActionType.ROCK) {
                return ResultType.PLAYER_1;
            }
            if (player2 == ActionType.PAPER) {
                return ResultType.TIE;
            }
            if (player2 == ActionType.SCISSORS) {
                return ResultType.PLAYER_2;
            }
            throw new IllegalArgumentException("Player 2 performed an unknown action");
        case ROCK:
            if (player2 == ActionType.ROCK) {
                return ResultType.TIE;
            }
            if (player2 == ActionType.PAPER) {
                return ResultType.PLAYER_2;
            }
            if (player2 == ActionType.SCISSORS) {
                return ResultType.PLAYER_1;
            }
            throw new IllegalArgumentException("Player 2 performed an unknown action");
        case SCISSORS:
            if (player2 == ActionType.ROCK) {
                return ResultType.PLAYER_2;
            }
            if (player2 == ActionType.PAPER) {
                return ResultType.PLAYER_1;
            }
            if (player2 == ActionType.SCISSORS) {
                return ResultType.TIE;
            }
            throw new IllegalArgumentException("Player 2 performed an unknown action");
        default:
            throw new IllegalArgumentException("Player 1 performed an unknown action");
        }
    }

}
