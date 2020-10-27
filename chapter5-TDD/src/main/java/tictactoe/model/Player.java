package tictactoe.model;

public interface Player {
    void markCell(Point point);
    void setCellValue(CellValue cellValue);
    String getName();
    CellValue getCellValue();
}
