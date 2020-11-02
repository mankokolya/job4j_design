package tictactoe.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private Cell[][] cells;

    private int size = 3;

    public Board() {
        initializeEmptyBoard(size);
    }

    public Board(int size) {
        if (size >= 3 && size % 2 != 0) {
            this.size = size;
            initializeEmptyBoard(this.size);
        } else {
            System.out.println("Field's size should be odd number");
        }
    }

    public boolean setPoint(int row, int column, CellValue cellValue) {
        boolean result = false;
        if (cellFree(row, column)) {
            cells[row][column].setCellValue(cellValue);
            result = true;
        }
        return result;
    }

    public int getSize() {
        return this.size;
    }

    private boolean cellFree(int row, int column) {
        return cells[row][column].getCellValue().equals("E");
    }

    private void initializeEmptyBoard(int size) {
        this.cells = new Cell[this.size][this.size];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j, CellValue.EMPTY);
            }
        }
    }

    public String getPointValue(int row, int column) {
        return this.cells[row][column].getCellValue();
    }

    public List<Cell> getFreeCells() {
        return Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .filter(cell -> cell.getCellValue().equals(CellValue.EMPTY.getValue()))
                .collect(Collectors.toList());
    }
}
