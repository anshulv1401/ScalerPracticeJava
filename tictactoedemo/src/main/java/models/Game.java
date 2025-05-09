package main.java.models;

import java.util.ArrayList;
import java.util.List;

import main.java.enums.CellState;
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

    public void makeMove() {
        var currPlayer = players.get(nextPlayerTurnIndex);
        System.out.println("It's " + currPlayer.getName() + "'s turn");

        var dummyCell = currPlayer.chooseCellToPlay(board);

        var validMove = board.isValidMove(dummyCell);
        if (!validMove) {
            System.out.println("Its an invlid move, please choose again?");
            return;
        }

        var boardCell = board.getBoard().get(dummyCell.getRow()).get(dummyCell.getCol());

        boardCell.setCellState(CellState.FILLED);
        boardCell.setPlayer(currPlayer);

        Move move = new Move(currPlayer, boardCell);
        moves.add(move);

        nextPlayerTurnIndex = (nextPlayerTurnIndex + 1) % players.size();

        // Check if this is a winning move
        if (checkWinner(move)) {
            winner = currPlayer;
            gameState = GameState.ENDED;
        } else if (moves.size() == (board.getDimension() * board.getDimension())) {
            gameState = GameState.DRAW;
        }
    }

    public void undoMove() {
        if (moves.size() == 0) {
            System.out.println("There are no moves on the board, undo not possible");
        }

        /*
         * Remove the last move from the list
         * Remove the move from the board, make the cell empty
         */

        var lastMove = moves.remove(moves.size() - 1);

        var boardCell = board.getBoard().get(lastMove.getCell().getRow()).get(lastMove.getCell().getCol());

        boardCell.setCellState(CellState.EMPTY);
        boardCell.setPlayer(null);

        nextPlayerTurnIndex = (nextPlayerTurnIndex - 1 + players.size()) % players.size();

        handleUndo(lastMove);
    }

    public boolean checkWinner(Move move) {

        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(move, board.getDimension())) {
                return true;
            }
        }
        return false;
    }

    public void handleUndo(Move move) {

        for (WinningStrategy winningStrategy : winningStrategies) {
            winningStrategy.handleUndo(move, board.getDimension());
        }
    }

    public void printBoard() {
        board.print();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    // #region getter & setters

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

    // #endregion

    // #region Builder

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

    // #endregion
}
