package tictactoe;

import tictactoe.controller.GameController;
import tictactoe.logic.StandardOneGameEvaluator;
import tictactoe.view.CommandLineView;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController = new GameController(new CommandLineView(), new StandardOneGameEvaluator());
        gameController.run();
    }
}
