package models;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel;

    public Bot(Character symbol, String name, int id, PlayerType playertype, BotDifficultyLevel difficultyLevel) {
        super(symbol, name, id, playertype);
        this.difficultyLevel = difficultyLevel;
    }
}
