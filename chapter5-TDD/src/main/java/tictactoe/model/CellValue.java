package tictactoe.model;

public enum CellValue {
    EMPTY(" "),
    CROSS("X"),
    ZERO("0");

    private final String value;

    CellValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
