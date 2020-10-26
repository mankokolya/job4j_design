package tictactoe.view;

import tictactoe.controller.GameController;

public interface View {

    void promptForPlayers();

    void promptForMove(String name);

    void promptForNewGame();

    void promptForPlayerToStart();

    void setController(GameController gc);

    void showPlayerName();

    void displayStartingPlayer(String name);

    void displayBoard();

    void showWinner(String name);
}
