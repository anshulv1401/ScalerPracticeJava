package main.java.factory;

import main.java.enums.BotDifficultyLevel;
import main.java.strategy.BotPlayingStrategy;
import main.java.strategy.EasyBotPlayingStrategy;
import main.java.strategy.HardBotPlayingStrategy;
import main.java.strategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy BotPlayingStrategyFactorys(BotDifficultyLevel botDifficultyLevel) {
        switch (botDifficultyLevel) {
            case EASY:
                return new EasyBotPlayingStrategy();
            case MEDIUM:
                return new MediumBotPlayingStrategy();
            default:
                return new HardBotPlayingStrategy();
        }
    }

}
