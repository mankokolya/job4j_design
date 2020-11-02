package tictactoe.model;

import java.util.Objects;

public abstract class Players implements Player {

    private String name;
    private PlayerType type;
    private CellValue cellValue;

    public Players(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }

    public void setCellValue(CellValue cellValue) {
        this.cellValue = cellValue;
    }


    public String getName() {
        return this.name;
    }

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
        return name.equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
