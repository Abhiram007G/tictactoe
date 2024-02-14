package Strategies;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Character,Integer>> colMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getCol();
        Character symbol = move.getPlayer().getSymbol();

        if(!colMaps.containsKey(col)){
            colMaps.put(col,new HashMap<>());
        }

        Map<Character,Integer> colMap = colMaps.get(col);
        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }
        colMap.put(symbol, colMap.get(symbol)+1);
        return colMap.get(symbol) == board.getDimension();

    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        int col = lastMove.getCell().getCol();
        Character symbol = lastMove.getPlayer().getSymbol();

        Map<Character,Integer> colMap = colMaps.get(col);
        colMap.put(symbol, colMap.get(symbol)-1);
    }
}
