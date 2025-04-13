package main.java.strategy.WinningStrategies;

import java.util.HashMap;
import java.util.Map;

import main.java.models.Move;
import main.java.models.Symbol;

public class RowWinningStrategy implements WinningStrategy {
    // Board
    // Move -> player, cell
    // Cell -> row, col, symbol

    // HM<int,HM<Symbol, count>>

    private Map<Integer, Map<Symbol, Integer>> rowHashMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, int dimension) {
        int row = move.getCell().getRow();
        var symbol = move.getPlayer().getSymbol();

        if (!rowHashMaps.containsKey(row)) {
            rowHashMaps.put(row, new HashMap<>());
        }

        var symbolHM = rowHashMaps.get(row);

        symbolHM.put(symbol, symbolHM.getOrDefault(symbol, 0) + 1);

        var totalCount = symbolHM.get(symbol);
        if (totalCount == dimension)
            return true;

        return false;
    }

}
