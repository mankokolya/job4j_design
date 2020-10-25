package tictactoe.model;

public class HumanPlayer implements Player {

    private String name;
    private String signature;

    HumanPlayer(String name, String signature) {
        this.name = name;
        this.signature = signature;
    }

    @Override
    public void markCell(Point point) {

    }
}
