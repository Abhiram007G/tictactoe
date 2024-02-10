package models;

import Exceptions.BotCountException;
import Exceptions.DuplicateSymbolForPlayer;
import Exceptions.PlayersAndDimensionMismatch;
import Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategy;

    private List<Move> moves;

    public Game(List<Player> players, int dimension,List<WinningStrategy> winningStrategy) {
        this.players = players;
        this.board = new Board(dimension);
        this.winningStrategy = winningStrategy;
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex=0;
        this.moves = new ArrayList<>();
    }

    public List<Player> getPlayersList() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public List<Move> getMovesList() {
        return moves;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void setPlayersList(List<Player> playersList) {
        this.players = playersList;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void setMovesList(List<Move> movesList) {
        this.moves = movesList;
    }

    public void printBoard() {
        board.printBoard();
    }

    public static class Builder {
        private List<Player> players;
        private int dimension;
        private List<WinningStrategy> winningStrategies;

        private Builder(){
            this.dimension=0;
            this.players = new ArrayList<>();
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Game build() throws BotCountException, DuplicateSymbolForPlayer, PlayersAndDimensionMismatch {
            validateBotCount();
            validateUniqueSymbolForEachPlayer();
            validateDimensionAndPlayerCount();

            return new Game(players, dimension, winningStrategies);
        }

        private void validateDimensionAndPlayerCount() throws PlayersAndDimensionMismatch {
            if(players.size() != (dimension-1)){
                throw new PlayersAndDimensionMismatch();
            }
        }

        private void validateUniqueSymbolForEachPlayer() throws DuplicateSymbolForPlayer {
            HashSet<Character> symbolsSet = new HashSet<>();

            for(Player player: players){
                if(symbolsSet.contains(player.getSymbol())){
                    throw new DuplicateSymbolForPlayer();
                }
                symbolsSet.add(player.getSymbol());
            }
        }

        private void validateBotCount() throws BotCountException {
            int botCount = 0;
            for(Player player: players){
                if(player.getPlayertype().equals(PlayerType.BOT)) botCount++;
                if (botCount>1){
                    throw new BotCountException();
                }
            }
        }



    }
}
