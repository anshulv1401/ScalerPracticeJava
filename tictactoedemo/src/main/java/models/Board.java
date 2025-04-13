package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        board = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void print() {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                System.out.print("");
            }
        }
    }

    public boolean isValidMove(Cell cell) {
        if (cell.getRow() < 0 || cell.getRow() >= dimension || cell.getCol() < 0 || cell.getCol() >= dimension) {
            return false;
        }
        return board.get(cell.getRow()).get(cell.getCol()).isEmpty();
    }

    // #region Getter and setter

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimenstion) {
        this.dimension = dimenstion;
    }

    // #endregion
}
