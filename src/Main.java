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
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws BotCountException, PlayersAndDimensionMismatch, DuplicateSymbolForPlayer {
        GameController gameController = new GameController();
        int dimension = 3;
        ArrayList<Player> players = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        players.add(new HumanPlayer('X',"Abhiram",1,PlayerType.HUMAN,scanner));
        players.add(new Bot('O',"Bard",2,PlayerType.BOT,BotDifficultyLevel.EASY));
//        players.add(new HumanPlayer('0',"Bard",2,PlayerType.HUMAN, scanner));

        ArrayList<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.createGame(players, dimension, winningStrategies);
        gameController.printBoard(game);

        gameController.makeMove(game);

        while (game.getGameState().equals(GameState.IN_PROGRESS)){
            gameController.printBoard(game);
            System.out.println("Do you want to undo? (y/n)");
            String choice = scanner.next();
            if(choice.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }
        gameController.printBoard(game);
        if (game.getGameState().equals(GameState.CONCLUDED)){
            System.out.println(game.getWinner().getName() + " is the winner!");
        }

        if( game.getGameState().equals(GameState.DRAW)){
            System.out.println("Its a DRAW");
        }


    }
}