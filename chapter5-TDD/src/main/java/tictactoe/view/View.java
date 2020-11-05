package tictactoe.view;

import tictactoe.controller.GameController;
import tictactoe.model.Board;
import tictactoe.model.CellValue;
import tictactoe.model.Players;

public interface View {

    void promptForPlayers();

//    void promptForMove(String name, CellValue cellValue);

    void promptForNewGame();

    void promptForPlayerToStart(Players player1, Players player2);

    void setController(GameController gc);

    void displayBoard(Board board);

    void showWinner(String name);

    void displayPlayers(String player1Name, String player2Name);

    void displayCellOccupied(int row, int column);

    void displayDrawResult(String drawResult);

    int getIntInput();
    void displayMessage(String message);

    void promptForBoardSize();
}
