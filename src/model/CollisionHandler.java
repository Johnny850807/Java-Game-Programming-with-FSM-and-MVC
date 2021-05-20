package model;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public interface CollisionHandler {
    void handle(Point originalLocation, Sprite from, Sprite to);
}
