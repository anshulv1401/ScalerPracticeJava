package main.java;

import java.util.ArrayList;
import java.util.List;

import main.java.contollers.GameController;
import main.java.enums.GameState;
import main.java.enums.PlayerType;
import main.java.models.Player;
import main.java.models.Symbol;
import main.java.strategy.WinningStrategies.ColumnWinningStrategy;
import main.java.strategy.WinningStrategies.DiagonalWinningStrategy;
import main.java.strategy.WinningStrategies.RowWinningStrategy;
import main.java.strategy.WinningStrategies.WinningStrategy;

public class App {
    public static void main(String[] args) throws Exception {

        List<Player> players = new ArrayList<>();
        players.add(new Player("Anshul", new Symbol('A', null), PlayerType.HUMAN));
        players.add(new Player("Rahul", new Symbol('R', null), PlayerType.HUMAN));
        players.add(new Player("Rakesh", new Symbol('H', null), PlayerType.HUMAN));

        var gameController = new GameController();

        List<WinningStrategy> winningStrategies = new ArrayList<>();

        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());

        var game = gameController.startGame(4, players, winningStrategies);

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            // Show the board

            // Tell whose turn it is

            // execute the move
        }

        System.out.println("Game Created");
    }
}
