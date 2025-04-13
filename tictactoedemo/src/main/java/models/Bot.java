package main.java.models;

import main.java.enums.BotDifficultyLevel;
import main.java.enums.PlayerType;

public class Bot extends Player {

    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Cell chooseCellToPlay() {
        return null;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
