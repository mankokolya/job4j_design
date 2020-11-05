package tictactoe.model;

import tictactoe.view.View;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Bot extends Players {

    public Bot(String name) {
        super("Bot: " + name);
    }

    @Override
    public void makeChoice(Board board, View view) {
//        view.displayMessage(super.getName() + " is making a choice.");
        List<Cell> freeCells = board.getFreeCells();
        int cellIndex = ThreadLocalRandom.current().nextInt(0, freeCells.size() - 1);
        Cell cell = freeCells.get(cellIndex);
        board.setPoint(cell.getRow(), cell.getColumn(), super.getCellValue());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
