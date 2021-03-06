package tictactoe.logic;

import tictactoe.model.Board;

public class StandardOneGameEvaluator implements GameEvaluator {

    @Override
    public boolean evaluate(Board board, String cellValue) {
        return checkHorizontal(board, cellValue) || checkVertical(board, cellValue) || checkDiagonal(board, cellValue);
    }

    private boolean checkDiagonal(Board board, String cellValue) {
        return checkLeftDiagonal(board, cellValue) || checkRightDiagonal(board, cellValue);
    }

    private boolean checkRightDiagonal(Board board, String cellValue) {
        int boardSize = board.getSize();
        int countValues = 0;
        for (int row = 0; row < boardSize; row++) {
            if (!board.getPointValue(row, boardSize - 1 - row).equals(cellValue)) {
                break;
            }
            countValues++;
        }
        return countValues == boardSize;
    }

    private boolean checkLeftDiagonal(Board board, String cellValue) {
        int boardSize = board.getSize();
        int countValues = 0;
        for (int row = 0; row < boardSize; row++) {
            if (!board.getPointValue(row, row).equals(cellValue)) {
                break;
            }
            countValues++;
        }
        return countValues == boardSize;

    }

    private boolean checkVertical(Board board, String cellValue) {
        int boardSize = board.getSize();
        int countValues = 0;
        for (int row = 0; row < boardSize; row++) {
            countValues = 0;
            for (int column = 0; column < boardSize; column++) {
                if (!board.getPointValue(column, row).equals(cellValue)) {
                    break;
                }
                countValues++;
            }
            if (countValues == boardSize) {
                break;
            }
        }
        return countValues == boardSize;
    }

    private boolean checkHorizontal(Board board, String cellValue) {
        int boardSize = board.getSize();
        int countValues = 0;
        for (int row = 0; row < boardSize; row++) {
            countValues = 0;
            for (int column = 0; column < boardSize; column++) {
                if (!board.getPointValue(row, column).equals(cellValue)) {
                    break;
                }
                countValues++;
            }
            if (countValues == boardSize) {
                break;
            }
        }
        return countValues == boardSize;
    }
}
