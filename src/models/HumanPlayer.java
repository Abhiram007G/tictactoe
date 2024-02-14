package models;

import java.util.Scanner;

public class HumanPlayer extends Player{

    public Scanner scanner;
    public HumanPlayer(Character symbol, String name, int id, PlayerType playertype, Scanner scanner) {
        super(symbol, name, id, playertype);
        this.scanner=scanner;
    }

    @Override
    public Cell makeMove(Board board) {
        System.out.println(getName() + " its your turn to make the move.");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

       while (!validateRowAndCol(row,col,board)){
           System.out.println(getName() + " its an invalid move, enter valid row and col again");
           row = scanner.nextInt();
           col = scanner.nextInt();
       }

       Cell cell = board.getBoard().get(row).get(col);
       cell.setPlayer(this);
       cell.setCellState(CellState.FILLED);
       return cell;
    }

    private boolean validateRowAndCol(int row, int col, Board board) {
        if (row >= board.getDimension() || row<0){
            return false;
        }
        if(col>= board.getDimension() || col<0){
            return false;
        }
        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.FILLED)) {
            return false;
        }
        return true;
    }
}
