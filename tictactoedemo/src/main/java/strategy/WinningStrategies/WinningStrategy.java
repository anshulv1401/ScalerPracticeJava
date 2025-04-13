package main.java.strategy.WinningStrategies;

import main.java.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Move move, int dimension);

    void handleUndo(Move move, int dimension);
}
