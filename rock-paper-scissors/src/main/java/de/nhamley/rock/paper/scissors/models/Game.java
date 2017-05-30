package de.nhamley.rock.paper.scissors.models;

import java.util.ArrayList;
import java.util.List;

import de.nhamley.rock.paper.scissors.evaluation.DefaultEvaluator;
import de.nhamley.rock.paper.scissors.evaluation.IEvaluator;
import de.nhamley.rock.paper.scissors.evaluation.ResultType;
import de.nhamley.rock.paper.scissors.results.Result;

/**
 * Class that represents a game of rock paper scissors, made up of multiple rounds.
 * 
 * @author nhamley
 *
 */
public class Game {

    private List<Player> players = new ArrayList<>();

    private IEvaluator evaluator;

    public Game() {
        evaluator = new DefaultEvaluator();
    }

    /**
     * Adds the given player to the game.
     * 
     * @param player
     *            the player that is added. Must not be null. Two players cannot have the same name.
     */
    public void addPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("A Player that is added to the game cannot be null");
        }
        if (players.contains(player)) {
            throw new IllegalArgumentException("Players must have Unique Names to participate");
        }
        players.add(player);
    }

    /**
     * Removes the given player from the game. Does nothing if the player is not part of the game.
     * 
     * @param player
     *            the player that is removed.
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }

    /**
     * Returns the amount of players currently playing.
     * 
     * @return the amount of players currently playing.
     */
    public int getAmountOfPlayers() {
        return players.size();
    }

    /**
     * Returns the result of playing the given amount of rounds.
     * 
     * @param rounds
     *            the amount of rounds that are played.
     * @return the results of the rounds.
     */
    public Result play(int rounds) {
        Result result = new Result();
        for (int i = 0; i < rounds; i++) {
            result.addResult(playRound());
        }
        return result;
    }

    /**
     * Plays one round of Rock Paper Scissors and returns the winner. Returns null if the result was a tie.
     * 
     * @return the player that won or null if it was a tie.
     */
    private Player playRound() {
        if (players.isEmpty()) {
            return null;
        }
        Player currentWinner = players.get(0);
        ActionType winningPlayType = currentWinner.getPlay();
        for (int i = 1; i < players.size(); i++) {
            Player playerB = players.get(i);
            ActionType playerBPlay = playerB.getPlay();
            ResultType result = evaluator.evalResult(winningPlayType, playerBPlay);
            switch (result) {
            case PLAYER_1:
                break;
            case PLAYER_2:
                currentWinner = playerB;
                winningPlayType = playerBPlay;
                break;
            case TIE:
                currentWinner = null;
                break;
            default:
                break;
            }
        }
        return currentWinner;
    }

}