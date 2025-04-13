package main.java.models;

import main.java.enums.BotDifficultyLevel;
import main.java.enums.PlayerType;
import main.java.factory.BotPlayingStrategyFactory;
import main.java.strategy.BotStrategies.BotPlayingStrategy;

public class Bot extends Player {

    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        botPlayingStrategy = BotPlayingStrategyFactory.BotPlayingStrategyFactorys(botDifficultyLevel);
    }

    @Override
    public Cell chooseCellToPlay(Board board) {
        return botPlayingStrategy.chooseCellToPlay(board);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
