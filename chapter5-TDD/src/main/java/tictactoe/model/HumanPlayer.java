package tictactoe.model;

import java.util.Objects;

public class HumanPlayer implements Player {

    private String name;
    private String signature;

    HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public void markCell(Point point) {

    }

    @Override
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanPlayer that = (HumanPlayer) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
