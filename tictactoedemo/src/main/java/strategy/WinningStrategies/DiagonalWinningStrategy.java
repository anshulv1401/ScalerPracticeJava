package main.java.strategy.WinningStrategies;

import java.util.HashMap;
import java.util.Map;

import main.java.models.Move;
import main.java.models.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy {

    private Map<Symbol, Integer> leftDiagMap = new HashMap<>();
    private Map<Symbol, Integer> rightDiagMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, int dimension) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        var symbol = move.getPlayer().getSymbol();

        if (row == col) {
            leftDiagMap.put(symbol, leftDiagMap.getOrDefault(symbol, 0) + 1);
            if (leftDiagMap.get(symbol) == dimension)
                return true;
        }
        if (row + col == dimension - 1) {
            rightDiagMap.put(symbol, rightDiagMap.getOrDefault(symbol, 0) + 1);
            if (rightDiagMap.get(symbol) == dimension)
                return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Move move, int dimension) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        var symbol = move.getPlayer().getSymbol();

        if (row == col) {
            leftDiagMap.put(symbol, leftDiagMap.getOrDefault(symbol, 0) - 1);
        }
        if (row + col == dimension - 1) {
            rightDiagMap.put(symbol, rightDiagMap.getOrDefault(symbol, 0) - 1);
        }
    }
}
