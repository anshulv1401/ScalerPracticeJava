package main.java.models;

import java.util.Scanner;

import main.java.enums.PlayerType;

public class Player {

    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Cell chooseCellToPlay(Board board) {

        System.out.println("Enter the row number where you want to play?");
        var inputRow = scanner.nextInt();
        System.out.println("Enter the col number where you want to play?");
        var inputCol = scanner.nextInt();

        return new Cell(inputRow, inputCol);
    }

    // #region Getter and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    // #endregion
}
