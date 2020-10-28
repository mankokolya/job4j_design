package tictactoe.model;

public enum PlayerType {
    Human("Human"),
    Bot("Bot");

    private final String value;

    PlayerType(String value) {
        this.value = value;
    }

    public static PlayerType forValue(String value) {
        for (PlayerType val : values()) {
            if (val.value.equals(value)) {
                return val;
            }
        }
        System.out.println("You entered the wrong type. Please choose correct one!!!");
        return null;
    }
}
