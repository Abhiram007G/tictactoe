package Strategies;

import models.Board;
import models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
