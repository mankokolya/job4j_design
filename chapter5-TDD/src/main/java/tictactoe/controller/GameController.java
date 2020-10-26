package tictactoe.controller;

import tictactoe.logic.GameEvaluator;
import tictactoe.model.*;
import tictactoe.view.View;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private enum GameState {
        AddingPlayers,
        ChooseWhoStarts,
        StartGame,
        WinnerRevealed;
    }

    private Field field;
    private List<Player> players;
    private Player winner;
    private View view;
    private GameState gameState;
    private int movesMade;
    private GameEvaluator evaluator;
    private Player currentPlayer;

   public GameController(View view, Field field, GameEvaluator evaluator) {
        this.view = view;
        this.field = field;
        players = Arrays.asList(new Player[2]);
        gameState = GameState.AddingPlayers;
        movesMade = 0;
        this.evaluator = evaluator;
        view.setController(this);
    }

    public void run() {
        while (true) {
            switch (gameState) {
                case AddingPlayers -> view.promptForPlayers();
                case ChooseWhoStarts -> view.promptForPlayerToStart();
                case WinnerRevealed -> view.promptForNewGame();
                default -> throw new IllegalStateException("Unexpected value: " + gameState);
            }
        }
    }

    public void addPlayer(PlayerType type, String name) {
        if (gameState == GameState.AddingPlayers) {
            players.add(PlayerFactory.createPlayer(type, name));
            view.showPlayerName();
        }
    }

    public void putStartingPlayerFirst(Player startingPlayer) {
        if (gameState == GameState.ChooseWhoStarts) {
            swapPlayers(startingPlayer);
            view.displayStartingPlayer(players.get(0).getName());
            assignSignature();
            currentPlayer = players.get(0);
            gameState = GameState.StartGame;
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
        while (winner == null && movesMade < field.getSize()) {
            view.displayBoard();
            view.promptForMove(currentPlayer.getName());
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
        if (evaluator.evaluate(this.field)) {
            winner = currentPlayer;
            result = true;
        }
        return result;
    }

    private void assignSignature() {
        players.get(0).setSignature(Signature.X.toString());
        players.get(1).setSignature(Signature.O.toString());
    }
}
