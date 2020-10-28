package tictactoe.model;


public class Cell {
    private int row;
    private int column;
    private CellValue cellValue;

    Cell(int row, int column, CellValue cellValue) {
        this.row = row;
        this.column = column;
        this.cellValue = cellValue;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setCellValue(CellValue cellValue) {
        this.cellValue = cellValue;
    }

    public String getCellValue() {
        return cellValue.getValue();
    }
}
