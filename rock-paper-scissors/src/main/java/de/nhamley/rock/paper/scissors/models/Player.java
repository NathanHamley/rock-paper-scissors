package de.nhamley.rock.paper.scissors.models;

import de.nhamley.rock.paper.scissors.strategies.IStrategy;

/**
 * Class that represents a Rock Paper Scissors player. Two players are equal if they have the same name.
 * 
 * @author nhamley
 */
public class Player {

    private IStrategy strategie;

    private String name;

    /**
     * Creates a new player with the given name and the given Strategy.
     * 
     * @param name
     *            the name of the player. Must not be null.
     * @param strategy
     *            the strategy that the player employs. Must not be null.
     */
    public Player(String name, IStrategy strategy) {
        if (name == null || strategy == null) {
            throw new IllegalArgumentException("A Player must have a name and a strategie, they may not be null");
        }
        this.name = name;
        this.strategie = strategy;
    }

    public String getName() {
        return name;
    }

    public ActionType getPlay() {
        return strategie.play();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player)obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}