package tictactoe.model;

import java.util.Objects;

public class HumanPlayer implements Player {

    private String name;
    private CellValue cellValue;

    HumanPlayer(String name) {
        this.name = name;
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
        HumanPlayer that = (HumanPlayer) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
