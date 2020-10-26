package tictactoe.view;

import tictactoe.controller.GameController;
import tictactoe.model.Board;
import tictactoe.model.Player;

public interface View {

    void promptForPlayers();

    void promptForMove(String name);

    void promptForNewGame();

    void promptForPlayerToStart(Player player1, Player player2);

    void setController(GameController gc);

    void showPlayerName();

    void displayStartingPlayer(String name);

    void displayBoard(Board board);

    void showWinner(String name);

    void displayPlayers(String player1Name, String player2Name);
}
