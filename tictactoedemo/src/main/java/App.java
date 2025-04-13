package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.contollers.GameController;
import main.java.enums.BotDifficultyLevel;
import main.java.enums.GameState;
import main.java.enums.PlayerType;
import main.java.models.Bot;
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
        players.add(new Bot("Rahul", new Symbol('R', null), BotDifficultyLevel.EASY));

        var gameController = new GameController();

        List<WinningStrategy> winningStrategies = new ArrayList<>();

        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());

        var game = gameController.startGame(3, players, winningStrategies);

        try (var sc = new Scanner(System.in)) {
            while (game.getGameState().equals(GameState.IN_PROGRESS)) {
                gameController.printBoard(game);
                gameController.makeMove(game);

                System.out.println("Do you want to do y/n");
                var undoAns = sc.next();

                if (undoAns.equalsIgnoreCase("y"))
                    gameController.undoMove(game);
            }
        }

        game.printBoard();
        if (game.getGameState().equals(GameState.ENDED))
            System.out.println("Winner is " + game.getWinner().getName());
        else
            System.out.println("Game is draw");
    }
}
