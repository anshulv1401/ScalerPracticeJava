package main.java.strategy.WinningStrategies;

import java.util.HashMap;
import java.util.Map;

import main.java.models.Move;
import main.java.models.Symbol;

public class ColumnWinningStrategy implements WinningStrategy {

    private Map<Integer, Map<Symbol, Integer>> colHashMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, int dimension) {
        int col = move.getCell().getCol();
        var symbol = move.getPlayer().getSymbol();

        if (!colHashMaps.containsKey(col)) {
            colHashMaps.put(col, new HashMap<>());
        }

        var symbolHM = colHashMaps.get(col);

        symbolHM.put(symbol, symbolHM.getOrDefault(symbol, 0) + 1);

        var totalCount = symbolHM.get(symbol);
        if (totalCount == dimension)
            return true;

        return false;
    }

    @Override
    public void handleUndo(Move move, int dimension) {
        int col = move.getCell().getCol();
        var symbol = move.getPlayer().getSymbol();

        var colMap = colHashMaps.get(col);

        colMap.put(symbol, colMap.get(symbol) - 1);
    }

}
