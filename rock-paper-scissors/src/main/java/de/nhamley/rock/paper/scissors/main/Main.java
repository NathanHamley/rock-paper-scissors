package de.nhamley.rock.paper.scissors.main;

import de.nhamley.rock.paper.scissors.models.Game;
import de.nhamley.rock.paper.scissors.models.Player;
import de.nhamley.rock.paper.scissors.strategies.AlwaysPaper;
import de.nhamley.rock.paper.scissors.strategies.RandomPlayType;

public class Main {
    public static void main(String[] args) {

        Player playerA = new Player("Player A", new AlwaysPaper());
        Player playerB = new Player("Player B", new RandomPlayType());
        Game game = new Game();
        game.addPlayer(playerA);
        game.addPlayer(playerB);
        System.out.println(game.play(100));
    }

}
