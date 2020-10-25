package tictactoe.model;

public class PlayerFactory {
    enum PlayerType {
        Human,
        Bot
    }

    public static Player createPlayer(PlayerType type, String name, String signature) {
        return switch (type) {
            case Human -> new HumanPlayer(name, signature);
            case Bot -> new Bot(name, signature);
        };
    }
}
