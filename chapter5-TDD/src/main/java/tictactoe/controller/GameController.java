package tictactoe.controller;

import tictactoe.logic.GameEvaluator;
import tictactoe.model.*;
import tictactoe.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public enum GameState {
        CreatingBoard,
        AddingPlayers,
        ChooseWhoStarts,
        WinnerRevealed,
        Start, Exit
    }

    private Board board;
    private List<Players> players;
    private Players winner;
    private View view;
    private GameState gameState;
    private int movesMade;
    private GameEvaluator evaluator;
    private Players currentPlayer;

    public GameController(View view, GameEvaluator evaluator) {
        this.view = view;
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        movesMade = 0;
        this.evaluator = evaluator;
        view.setController(this);
    }

    public void run() {
        boolean playTheGame = true;
        while (playTheGame) {
            switch (gameState) {
                case AddingPlayers -> view.promptForPlayers();
                case ChooseWhoStarts -> view.promptForPlayerToStart(players.get(0), players.get(1));
                case CreatingBoard -> view.promptForBoardSize();
                case Start -> startGame();
                case WinnerRevealed -> view.promptForNewGame();
                case Exit -> {
                    playTheGame = false;
                }
                default -> throw new IllegalStateException("Unexpected value: " + gameState);
            }
        }
    }

    public void addPlayer(PlayerType type, String name) {
        if (gameState == GameState.AddingPlayers) {
            players.add(PlayerFactory.createPlayer(type, name));
        }
    }

    public void putStartingPlayerFirst(Players startingPlayer) {
        if (gameState == GameState.ChooseWhoStarts) {
            swapPlayers(startingPlayer);
            assignSignature();
            currentPlayer = players.get(0);
        }
    }

    private void swapPlayers(Players startingPlayer) {
        if (players.get(0) != startingPlayer) {
            Players temp = players.get(0);
            players.set(0, players.get(1));
            players.set(1, temp);
        }
    }

    public void startGame() {
        view.displayPlayers(players.get(0).getName(), players.get(1).getName());
        while (winner == null && movesMade < (int) Math.pow(board.getSize(), 2)) {
            view.displayBoard(this.board);
            currentPlayer.makeChoice(this.board, view);
            movesMade++;
            if (!evaluateWinner()) {
                changeCurrentPlayer();
            }
        }
        view.displayBoard(this.board);
        displayWinner();
        gameState = GameState.WinnerRevealed;
    }

    private void displayWinner() {
        if (winner != null) {
            view.showWinner(winner.getName());
        } else {
            view.displayDrawResult("We have a draw");
        }
    }

    private void changeCurrentPlayer() {
        currentPlayer = (currentPlayer == players.get(0)) ? players.get(1) : players.get(0);
    }

    private boolean evaluateWinner() {
        boolean result = false;
        if (evaluator.evaluate(this.board, this.currentPlayer.getCellValue().getValue())) {
            winner = currentPlayer;
            result = true;
        }
        return result;
    }

    private void assignSignature() {
        players.get(0).setCellValue(CellValue.CROSS);
        players.get(1).setCellValue(CellValue.ZERO);
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public String getPoint(int row, int column) {
        return this.board.getPointValue(row, column);
    }

    public void createNewBoard(int size) {
        if (size >= 3 && size % 2 != 0) {
            this.board = new Board(size);
        } else {
            this.board = new Board();
        }
        winner = null;
        movesMade = 0;
        gameState = GameState.Start;
    }
}