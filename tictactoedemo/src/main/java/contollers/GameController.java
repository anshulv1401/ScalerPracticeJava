package main.java.contollers;

import java.util.List;

import main.java.exceptions.PlayerCountNotValidException;
import main.java.models.Game;
import main.java.models.Player;
import main.java.strategy.WinningStrategies.WinningStrategy;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> strategies)
            throws PlayerCountNotValidException {

        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setStrategies(strategies)
                .build();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void undoMove() {

    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}
