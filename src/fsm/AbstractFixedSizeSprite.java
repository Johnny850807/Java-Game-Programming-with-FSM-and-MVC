package fsm;

import model.Direction;
import model.Sprite;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class AbstractFixedSizeSprite extends Sprite {
    protected Point location;
    protected Dimension size;
    protected Dimension bodyOffset;
    protected Dimension bodySize;

    public AbstractFixedSizeSprite(Point location,
                                   Dimension size,
                                   Dimension bodyOffset, Dimension bodySize) {
        this.location = location;
        this.size = size;
        this.bodyOffset = bodyOffset;
        this.bodySize = bodySize;
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public Rectangle getRange() {
        return new Rectangle(location, size);
    }

    @Override
    public Dimension getBodyOffset() {
        return bodyOffset;
    }

    @Override
    public Dimension getBodySize() {
        return bodySize;
    }
}
