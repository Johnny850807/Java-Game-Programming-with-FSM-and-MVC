package model;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class SpriteShape {
    public Dimension size;
    public Dimension bodyOffset;
    public Dimension bodySize;

    public SpriteShape(Dimension size,
                       Dimension bodyOffset, Dimension bodySize) {
        this.size = size;
        this.bodyOffset = bodyOffset;
        this.bodySize = bodySize;
    }
}
