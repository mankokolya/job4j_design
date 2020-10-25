package tictactoe.model;

public class Bot implements Player {

    private String name = "Bot: ";
    private String signature;

    Bot(String name, String signature) {
        this.signature = signature;
        this.name += name;
    }

    @Override
    public void markCell(Point point) {

    }
}
