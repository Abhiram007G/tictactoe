package Strategies;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    Map<Character,Integer> leftDiaMap = new HashMap<>();
    Map<Character,Integer> rightDiaMap = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row= move.getCell().getRow();
        int col =move.getCell().getCol();
        Character symbol = move.getPlayer().getSymbol();

        if(row==col){
            if(!rightDiaMap.containsKey(symbol)){
                rightDiaMap.put(symbol,0);
            }
            rightDiaMap.put(symbol, rightDiaMap.get(symbol)+1);

            if(rightDiaMap.get(symbol)== board.getDimension()){
                return true;
            }
        }

        if(row+col ==(board.getDimension()-1)){
            if(!leftDiaMap.containsKey(symbol)){
                leftDiaMap.put(symbol,0);
            }
            leftDiaMap.put(symbol, leftDiaMap.get(symbol)+1);

            if(leftDiaMap.get(symbol)== board.getDimension()){
                return true;
            }
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        int row= lastMove.getCell().getRow();
        int col =lastMove.getCell().getCol();
        Character symbol = lastMove.getPlayer().getSymbol();

        if(row==col){
            rightDiaMap.put(symbol,rightDiaMap.get(symbol)-1);
        }
        if(row+col == (board.getDimension()-1)){
            leftDiaMap.put(symbol,leftDiaMap.get(symbol)-1);
        }

    }
}
