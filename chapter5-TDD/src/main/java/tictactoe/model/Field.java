package tictactoe.model;

public class Field {
    private Point[][] points;

    private int size = 3;

    Field() {
        points = new Point[this.size][this.size];
    }

    Field(int size) {
        if (size >= 3 && size % 2 != 0) {
            this.size = size;
            this.points = new Point[this.size][this.size];
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

    private boolean cellFree(int row, int column) {
        return points[row][column] == null;
    }
}
