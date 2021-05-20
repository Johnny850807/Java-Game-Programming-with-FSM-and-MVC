package model;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public void translate(Point location) {
        switch (this) {
            case UP:
                location.translate(0, -6);
                break;
            case DOWN:
                location.translate(0, 6);
                break;
            case LEFT:
                location.translate(-6, 0);
                break;
            case RIGHT:
                location.translate(6, 0);
                break;
        }
    }
}
