package de.nhamley.rock.paper.scissors.results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.nhamley.rock.paper.scissors.models.Player;

/**
 * Class that represents the results of playing multiple rounds of Rock Paper Scissors.
 * 
 * @author nhamley
 *
 */
public class Result {
    private Map<Player, Integer> results = new HashMap<>();

    private int totalGames = 0;

    /**
     * Adds a result by specifying the winning player.
     * 
     * @param player
     *            the player that won, or null if it was a tie.
     */
    public void addResult(Player player) {
        if (results.containsKey(player)) {
            results.put(player, results.get(player) + 1);
        } else {
            results.put(player, 1);
        }
        totalGames++;
    }

    /**
     * Returns the amount of wins the given player achieved. If the player has not participated, he won 0 times.
     * 
     * @param player
     *            the player whose wins are returned.
     * @return the amount of times the given player won.
     */
    public int getWinsForPlayer(Player player) {
        if (!results.containsKey(player)) {
            return 0;
        }
        return results.get(player);
    }

    /**
     * Returns the amount of ties that occurred.
     * 
     * @return the amount of ties that occurred
     */
    public int getTies() {
        return getWinsForPlayer(null);
    }

    /**
     * Returns the total amount of games played.
     * 
     * @return the total amount of games played.
     */
    public int getTotalGamesPlayed() {
        return totalGames;
    }

    @Override
    public String toString() {
        List<String> outputList = new ArrayList<>();
        for (Player p : results.keySet()) {
            String name = p == null ? "Tie: " : p.getName() + " wins ";
            outputList.add(name + results.get(p) + " of " + totalGames + " games");
        }
        Collections.sort(outputList);
        StringBuilder res = new StringBuilder();
        for(String s: outputList){
            res.append(s + "\n");
        }
        return res.toString();
    }

}