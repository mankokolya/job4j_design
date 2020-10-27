package tictactoe.model;

import java.util.Objects;

public class Bot implements Player {

    private String name = "Bot: ";
    private CellValue cellValue;

    Bot(String name) {
        this.name += name;
    }

    @Override
    public void markCell(Point point) {

    }

    @Override
    public void setCellValue(CellValue cellValue) {
        this.cellValue = cellValue;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public CellValue getCellValue() {
        return this.cellValue;
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
