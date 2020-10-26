package tictactoe.model;

public class PlayerFactory {

    public static Player createPlayer(PlayerType type, String name) {
        return switch (type) {
            case Human -> new HumanPlayer(name);
            case Bot -> new Bot(name);
        };
    }
}
