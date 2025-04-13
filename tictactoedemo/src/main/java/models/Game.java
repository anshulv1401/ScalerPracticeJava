package main.java.models;

import java.util.List;

import main.java.enums.GameState;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player player;
    private int nextPlayerTurnIndex;
    private GameState gameState;

    public Game() {

    }
}
