package tictactoe.model;

import tictactoe.view.View;

public class HumanPlayer extends Players {

    HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void makeChoice(Board board, View view) {
        int boardSize = board.getSize();
        int row = getRow(super.getName(), boardSize, view);
        int column = getColumn(boardSize, view);
        if (!board.setPoint(row - 1, column - 1, super.getCellValue())) {
            view.displayCellOccupied(row, column);
            makeChoice(board, view);
        }
    }

    private int getRow(String name, int boardSize, View view) {
        view.displayMessage(name + "! Make your choice. \nEnter row index of free cell: ");
        int row = view.getIntInput();
        while (row > boardSize || row < 1) {
            view.displayMessage("Your entered a wrong index value. Please try again!");
            row = getRow(name, boardSize, view);
        }
        return row;
    }

    private int getColumn(int boardSize, View view) {
        view.displayMessage("Enter column index of free cell: ");
        int column = view.getIntInput();
        while (column > boardSize || column < 1) {
            column = getColumn(boardSize, view);
        }
        return column;
    }
}
