package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int dimenstion;

    public Board(int dimenstion) {
        this.dimenstion = dimenstion;
        board = new ArrayList<>();

        for (int i = 0; i < dimenstion; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < dimenstion; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimenstion() {
        return dimenstion;
    }

    public void setDimenstion(int dimenstion) {
        this.dimenstion = dimenstion;
    }
}
