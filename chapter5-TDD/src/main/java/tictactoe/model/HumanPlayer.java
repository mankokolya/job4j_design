package tictactoe.model;

public class HumanPlayer extends Players {

    HumanPlayer(String name, PlayerType type) {
        super(name, type);
    }

    @Override
    public Cell makeChoice(Board board) {
        return null;
    }
}
