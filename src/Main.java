import Exceptions.BotCountException;
import Exceptions.DuplicateSymbolForPlayer;
import Exceptions.PlayersAndDimensionMismatch;
import Strategies.ColWinningStrategy;
import Strategies.DiagonalWinningStrategy;
import Strategies.RowWinningStrategy;
import Strategies.WinningStrategy;
import controllers.GameController;
import models.Game;
import models.*;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws BotCountException, PlayersAndDimensionMismatch, DuplicateSymbolForPlayer {
        GameController gameController = new GameController();
        int dimension = 3;
        ArrayList<Player> players = new ArrayList<>();

        players.add(new HumanPlayer('X',"Abhiram",1,PlayerType.HUMAN));
        players.add(new Bot('O',"Bard",2,PlayerType.BOT,BotDifficultyLevel.EASY));

        ArrayList<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.createGame(players, dimension, winningStrategies);
        game.printBoard();

    }
}