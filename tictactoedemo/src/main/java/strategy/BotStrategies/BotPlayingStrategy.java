package main.java.strategy.BotStrategies;

import main.java.models.Board;
import main.java.models.Cell;

public interface BotPlayingStrategy {
    Cell chooseCellToPlay(Board board);
}
