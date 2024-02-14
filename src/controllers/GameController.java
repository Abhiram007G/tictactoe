package controllers;

import Exceptions.BotCountException;
import Exceptions.DuplicateSymbolForPlayer;
import Exceptions.PlayersAndDimensionMismatch;
import Strategies.WinningStrategy;
import models.Game;
import models.Player;

import java.util.List;

public class GameController {
    public Game createGame(List<Player> playerList, int dimension, List<WinningStrategy> winningStrategyList) throws BotCountException, PlayersAndDimensionMismatch, DuplicateSymbolForPlayer {
        return Game.getBuilder()
                .setPlayers(playerList)
                .setDimension(dimension)
                .setWinningStrategies(winningStrategyList)
                .build();

    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void undo(Game game){
        game.undo();
    }


}
