package tictactoe.model;

public interface Player {
    void markCell(Point point);
    void setSignature(String signature);
    String getName();
}
