package fsm;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class ImageState implements State {
    private final Image image;
    protected ImageRenderer render;

    public ImageState(Image image, ImageRenderer render) {
        this.image = image;
        this.render = render;
    }

    @Override
    public void update() {
        // No effects: just an image
    }

    @Override
    public void render(Graphics g) {
        render.render(image, g);
    }
}
