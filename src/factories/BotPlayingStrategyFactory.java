package factories;

import Strategies.BotPlayingStrategy;
import Strategies.EasyBotPlayingStrategy;
import models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel){
        return new EasyBotPlayingStrategy();
    }
}
