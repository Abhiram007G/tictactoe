package models;

import Strategies.BotPlayingStrategy;
import factories.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(Character symbol, String name, int id, PlayerType playertype, BotDifficultyLevel difficultyLevel) {
        super(symbol, name, id, playertype);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);

    }

    @Override
    public Cell makeMove(Board board) {

        System.out.println( getName() + " is making the move");
        Cell cell=botPlayingStrategy.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }
}
