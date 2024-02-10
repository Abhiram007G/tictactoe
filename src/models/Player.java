package models;

public abstract class Player {
    private Character symbol;
    private String name;
    private int id;
    private PlayerType playertype;

    public Player(Character symbol, String name, int id, PlayerType playertype){

        this.symbol = symbol;
        this.name = name;
        this.id = id;
        this.playertype = playertype;
    }

    public Character getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public PlayerType getPlayertype() {
        return playertype;
    }
}
