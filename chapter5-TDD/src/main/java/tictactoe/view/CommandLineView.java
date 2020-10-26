package tictactoe.view;

import tictactoe.controller.GameController;
import tictactoe.model.Player;
import tictactoe.model.PlayerFactory;
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
    public void promptForMove(String name) {

    }

    @Override
    public void promptForNewGame() {

    }

    @Override
    public void promptForPlayerToStart() {

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
    public void displayBoard() {

    }

    @Override
    public void showWinner(String name) {

    }
}
