package tictactoe.view;

import tictactoe.controller.GameController;
import tictactoe.model.Board;
import tictactoe.model.CellValue;
import tictactoe.model.Player;
import tictactoe.model.PlayerType;

import java.util.Scanner;

public class CommandLineView implements View {

    private GameController controller;
    private Scanner keyboard = new Scanner(System.in);


    @Override
    public void promptForPlayers() {
        for (int i = 0; i < 2; i++) {
            PlayerType type = getPlayerType();
            System.out.print("Enter player's name: ");
            String name = keyboard.nextLine();
            controller.addPlayer(type, name);
        }
        controller.setGameState(GameController.GameState.ChooseWhoStarts);
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
    public void promptForMove(String name, CellValue cellValue) {
        System.out.println(name + "! Make your choice.");
        System.out.print("Enter row index of free cell: ");
        int row = keyboard.nextInt();
        System.out.print("Enter column index of free cell: ");
        int column = keyboard.nextInt();
        controller.setPoint(row, column, cellValue);
    }

    @Override
    public void promptForNewGame() {

    }

    @Override
    public void promptForPlayerToStart(Player player1, Player player2) {
        System.out.println("Choose the player who starts the game.");
        System.out.println("1 for " + player1.getName() + System.lineSeparator() + "2 for " + player2.getName());
        int playerNumber = keyboard.nextInt();
        controller.putStartingPlayerFirst(playerNumber == 1 ? player1 : player2);
        controller.startGame();
    }

    @Override
    public void setController(GameController gc) {
        this.controller = gc;
    }

    @Override
    public void showPlayerName() {

    }

    @Override
    public void displayStartingPlayer(String name) {

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
    }

    private void displayRowsDelimiter(int size) {
        for (int i = 0; i <= size * 5 - 1; i++) {
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

    }

    @Override
    public void displayPlayers(String player1Name, String player2Name) {
        System.out.println("First player: " + player1Name + System.lineSeparator() + "Second player: " + player2Name);
    }
}