package Strategies;

import models.Board;
import models.Move;

public class ColWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
