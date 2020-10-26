package tictactoe.model;

import java.util.Objects;

public class Bot implements Player {

    private String name = "Bot: ";
    private String signature;

    Bot(String name) {
        this.name += name;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bot bot = (Bot) o;
        return name.equals(bot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
