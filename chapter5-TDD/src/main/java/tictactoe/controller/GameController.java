package tictactoe.controller;

import tictactoe.model.Field;

import java.util.ArrayList;

class View {
    public void something() {
    }

    public void setController(GameController gc) {
    }
}

public class GameController {
    private enum GameState {
        AddingPlayers,
        MakingMove,
        CheckWinner,
        WinnerRevealed;
    }

    private Field field;
    private ArrayList<Player> players;
    private Player winner;
    private View view;
    private GameState gameState;

    GameController(View view, Field field) {
        this.view = view;
        this.field = field;
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        view.setController(this);
    }

    public void run() {
        while (true) {
            switch (gameState) {
                case AddingPlayers -> view.promptForPlayersName();
                case WinnerRevealed -> view.promptForNewGaME();
            }
        }
    }

    public void addPlayer(Player player) {
        if (gameState == GameState.AddingPlayers) {
            players.add(player);
            view.something();
        }
    }

    public void startGame() {
        evaluateWinner();
        displayWinner();
        gameState  = GameState.WinnerRevealed;
    }
}
