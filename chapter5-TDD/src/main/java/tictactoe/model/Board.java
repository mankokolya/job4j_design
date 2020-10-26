package tictactoe.model;

public class Board {
    private Point[][] points;

    private int size = 3;

    public Board() {
        initializeEmptyBoard(size);
    }


    Board(int size) {
        if (size >= 3 && size % 2 != 0) {
            this.size = size;
            initializeEmptyBoard(this.size);
        }
        System.out.println("Field's size should be odd number");
    }

    public void setPoint(Point point) {
        int row = point.getRow();
        int column = point.getColumn();
        if (cellFree(row, column)) {
            points[row][column] = point;
        }
    }

    public int getSize() {
        return this.size;
    }

    private boolean cellFree(int row, int column) {
        return points[row][column] == null;
    }

    private void initializeEmptyBoard(int size) {
        this.points = new Point[this.size][this.size];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = new Point(i, j, CellValue.EMPTY);
            }
        }
    }

    public String getPoint(int row, int column) {
        return this.points[row][column].getCellValue();
    }
}
