package tictactoe.model;

public class PlayerFactory {

    public static Players createPlayer(PlayerType type, String name) {
        return switch (type) {
            case Human -> new HumanPlayer(name, type);
            case Bot -> new Bot(name, type);
        };
    }
}
