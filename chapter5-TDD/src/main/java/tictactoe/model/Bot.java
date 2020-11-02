package tictactoe.model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Bot extends Players {

    public Bot(String name, PlayerType type) {
        super("Bot: " + name, type);
    }

    @Override
    public Cell makeChoice(Board board) {
        List<Cell> freeCells = board.getFreeCells();
        int cellIndex = ThreadLocalRandom.current().nextInt(0, freeCells.size() - 1);
        return freeCells.get(cellIndex);
    }
}
