package model;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class Sprite {
    protected World world;
    protected Point location;

    public abstract void update();

    public abstract void render(Graphics g);

    public void setWorld(World world) {
        this.world = world;
    }

    public Point getLocation() {
        return location;
    }

    public abstract Rectangle getRange();

    public abstract Dimension getBodyOffset();

    public abstract Dimension getBodySize();

    public Rectangle getBody() {
        Dimension offset = getBodyOffset();
        return new Rectangle(new Point(offset.width + location.x,
                offset.height + location.y), getBodySize());
    }

}
