package main.java.strategy.BotStrategies;

import main.java.models.Board;
import main.java.models.Cell;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Cell chooseCellToPlay(Board board) {
        for (var cellList : board.getBoard()) {
            for (var cell : cellList) {
                if (cell.isEmpty())
                    return cell;
            }
        }

        return null;
    }

}
