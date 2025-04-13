package main.java.factory;

import main.java.enums.BotDifficultyLevel;
import main.java.strategy.BotStrategies.BotPlayingStrategy;
import main.java.strategy.BotStrategies.EasyBotPlayingStrategy;
import main.java.strategy.BotStrategies.HardBotPlayingStrategy;
import main.java.strategy.BotStrategies.MediumBotPlayingStrategy;

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
