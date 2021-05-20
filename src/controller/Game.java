package controller;

import extensions.Knight;
import model.Direction;
import model.Sprite;
import model.World;

import java.util.Collection;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Game extends GameLoop {
    private final Knight knight;
    private final World world;

    public Game(World world, Knight knight) {
        this.knight = knight;
        this.world = world;
        world.addSprite(knight);
    }

    public void moveKnight(Direction direction) {
        knight.move(direction);
    }

    public void stopKnight(Direction direction) {
        knight.stop(direction);
    }

    public void attack() {
        knight.attack();
    }

    @Override
    protected Collection<Sprite> getSprites() {
        return world.getSprites();
    }
}
