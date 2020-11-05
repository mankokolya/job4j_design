package tictactoe.model;

import tictactoe.view.View;

public interface Player {
    void makeChoice(Board board, View view);
}
