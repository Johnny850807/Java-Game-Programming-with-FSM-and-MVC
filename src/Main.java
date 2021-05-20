import controller.Game;
import extensions.Knight;
import model.World;
import views.GameView;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight(new Point(0, 0));
        World world = new World(knight);
        Game game = new Game(world, knight);
        GameView view = new GameView(game);
        game.start();
        view.launch();
    }
}
