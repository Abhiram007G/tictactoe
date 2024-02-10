package models;

public class Cell {
    int row;
    int col;
    private CellState cellState;
    private Player player;

    public Cell(int row, int col){
        this.row=  row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void printCell() {
        if (cellState.equals(CellState.FILLED)){
            System.out.print("| " + player.getSymbol() + " |");
        }
        else{
            System.out.print("| - |");
        }
    }
}
