package tictactoe.view;

import tictactoe.controller.GameController;
import tictactoe.model.*;

import java.util.Scanner;

import static tictactoe.controller.GameController.GameState.ChooseWhoStarts;
import static tictactoe.controller.GameController.GameState.Exit;

public class CommandLineView implements View {

    private GameController controller;
    private final Scanner keyboard = new Scanner(System.in);

    @Override
    public void promptForPlayers() {
        for (int i = 0; i < 2; i++) {
            PlayerType type = getPlayerType();
            System.out.print("Enter player's name: ");
            String name = keyboard.nextLine();
            controller.addPlayer(type, name);
        }
        controller.setGameState(ChooseWhoStarts);
    }

    private PlayerType getPlayerType() {
        PlayerType type = null;
        while (type == null) {
            System.out.print("Enter player's type(Human, Bot): ");
            type = PlayerType.forValue(keyboard.nextLine());
        }
        return type;
    }

    @Override
    public void promptForNewGame() {
        System.out.println("If you would like to play again please enter 1 else 0");
        int choice = keyboard.nextInt();
        controller.setGameState(choice == 1 ? ChooseWhoStarts : Exit);
    }

    @Override
    public void promptForPlayerToStart(Players player1, Players player2) {
        System.out.println("Choose the player who starts the game.");
        System.out.println("1 for " + player1.getName() + System.lineSeparator() + "2 for " + player2.getName());
        int playerNumber = keyboard.nextInt();
        controller.putStartingPlayerFirst(playerNumber == 1 ? player1 : player2);
        controller.setGameState(GameController.GameState.CreatingBoard);
    }

    @Override
    public void setController(GameController gc) {
        this.controller = gc;
    }

    @Override
    public void displayBoard(Board board) {
        displayHeader(board.getSize());
        displayRowsDelimiter(board.getSize());
        for (int i = 0; i < board.getSize(); i++) {
            System.out.print(i + 1 + "| ");
            for (int j = 0; j < board.getSize(); j++) {
                System.out.print(controller.getPoint(i, j) + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void displayRowsDelimiter(int size) {
        for (int i = 0; i <= size * 4 + 1; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    private void displayHeader(int size) {
        for (int i = 0; i <= size; i++) {
            if (i == 0) {
                continue;
            }
            System.out.print(" | " + i);
        }
        System.out.println(" |");
    }

    @Override
    public void showWinner(String name) {
        System.out.println(name + " is the Winner of the game");
    }

    @Override
    public void displayPlayers(String player1Name, String player2Name) {
        System.out.println("First player: " + player1Name + System.lineSeparator() + "Second player: " + player2Name);
    }

    @Override
    public void displayCellOccupied(int row, int column) {
        System.out.println("the cell with row " + row + " and column " + column + " is occupied");
        System.out.println("Please choose empty one");
    }

    @Override
    public void displayDrawResult(String drawResult) {
        System.out.println(drawResult);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void promptForBoardSize() {
        System.out.println("Enter the size of the playing board.");
        System.out.println("The number should be odd(3, 5, 7, 9 ...)");
        System.out.println("Else you will be provided with default size - 3");
        int size = getIntInput();
        controller.createNewBoard(size);
    }

    @Override
    public int getIntInput() {
        return keyboard.nextInt();
    }
}
