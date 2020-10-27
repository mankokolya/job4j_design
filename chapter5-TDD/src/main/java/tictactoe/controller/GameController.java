package tictactoe.controller;

import tictactoe.logic.GameEvaluator;
import tictactoe.model.*;
import tictactoe.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public enum GameState {
        AddingPlayers,
        ChooseWhoStarts,
        WinnerRevealed;
    }

    private Board board;
    private List<Player> players;
    private Player winner;
    private View view;
    private GameState gameState;
    private int movesMade;
    private GameEvaluator evaluator;
    private Player currentPlayer;

    public GameController(View view, Board board, GameEvaluator evaluator) {
        this.view = view;
        this.board = board;
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        movesMade = 0;
        this.evaluator = evaluator;
        view.setController(this);
    }

    public void run() {
        while (true) {
            switch (gameState) {
                case AddingPlayers -> view.promptForPlayers();
                case ChooseWhoStarts -> view.promptForPlayerToStart(players.get(0), players.get(1));
                case WinnerRevealed -> view.promptForNewGame();
                default -> throw new IllegalStateException("Unexpected value: " + gameState);
            }
        }
    }

    public void addPlayer(PlayerType type, String name) {
        if (gameState == GameState.AddingPlayers) {
            players.add(PlayerFactory.createPlayer(type, name));
        }
    }

    public void putStartingPlayerFirst(Player startingPlayer) {
        if (gameState == GameState.ChooseWhoStarts) {
            swapPlayers(startingPlayer);
            view.displayStartingPlayer(players.get(0).getName());
            assignSignature();
            currentPlayer = players.get(0);
        }
    }

    private void swapPlayers(Player startingPlayer) {
        if (players.get(0) != startingPlayer) {
            Player temp = players.get(0);
            players.set(0, players.get(1));
            players.set(1, temp);
        }
    }

    public void startGame() {
        view.displayPlayers(players.get(0).getName(), players.get(1).getName());
        while (winner == null && movesMade < board.getSize()) {
            view.displayBoard(this.board);
            view.promptForMove(currentPlayer.getName(), currentPlayer.getCellValue());
            if (!evaluateWinner()) {
                changeCurrentPlayer();
            }
        }
        displayWinner();
        gameState = GameState.WinnerRevealed;
    }

    private void displayWinner() {
        view.showWinner(winner.getName());
    }

    private void changeCurrentPlayer() {
        currentPlayer = (currentPlayer == players.get(0)) ? players.get(1) : players.get(0);
    }

    private boolean evaluateWinner() {
        boolean result = false;
        if (evaluator.evaluate(this.board)) {
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
        return this.board.getPoint(row, column);
    }

    public void setPoint(int row, int column, CellValue cellValue) {
        if (!this.board.setPoint(row, column, cellValue)) {
            view.promptForMove(currentPlayer.getName(), currentPlayer.getCellValue());
        }
    }
}