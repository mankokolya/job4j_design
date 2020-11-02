package tictactoe.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BotTest {

    @Test
    public void createBot() {
        Players bot = new Bot("Nick", PlayerType.Bot);
        assertEquals("Bot: Nick", bot.getName());
    }

    @Test
    public void makeChoice() {
        Players bot = new Bot("Nick", PlayerType.Bot);
        Board board = new Board();
        Cell cell = bot.makeChoice(board);
        System.out.println(cell.getRow() + " " + cell.getColumn());
        assertTrue(cell.getRow() >= 0);
        assertTrue(cell.getRow() < board.getSize());
        assertTrue(cell.getColumn() >= 0);
        assertTrue(cell.getColumn() < board.getSize());
    }
}