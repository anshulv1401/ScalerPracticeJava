package main.java.models;

import java.util.ArrayList;
import java.util.List;

import main.java.enums.GameState;
import main.java.enums.PlayerType;
import main.java.exceptions.PlayerCountNotValidException;
import main.java.strategy.WinningStrategies.WinningStrategy;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerTurnIndex;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.nextPlayerTurnIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerTurnIndex() {
        return nextPlayerTurnIndex;
    }

    public void setNextPlayerTurnIndex(int nextPlayerTurnIndex) {
        this.nextPlayerTurnIndex = nextPlayerTurnIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player checkWinner(Move move) {
        // // algo to check the winner along the rows, cols, diag
        // for (WinningStrategy winningStrategy : winningStrategies) {
        // if (winningStrategy.checkWinner(move, board.getDimension())) {
        // return true;
        // }
        // }
        // return false;
        return null;
    }

    public static class Builder {

        private int dimension = 0;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public void validateUniqueSymbols() throws PlayerCountNotValidException {

            if (players.size() != dimension - 1) {
                throw new PlayerCountNotValidException("Player's count not equal to dimention");
            }
        }

        public void validateBotCount() throws PlayerCountNotValidException {
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT))
                    botCount++;
            }

            if (botCount > dimension - 2) {
                throw new PlayerCountNotValidException("Atleast 1 player is required");
            }
        }

        public Game build() throws PlayerCountNotValidException {
            validateUniqueSymbols();
            validateBotCount();
            // TODO validate unique symbols
            return new Game(dimension, players, winningStrategies);
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }
}
