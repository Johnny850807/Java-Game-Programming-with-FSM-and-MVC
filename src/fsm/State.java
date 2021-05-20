package fsm;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public interface State {
    void update();

    void render(Graphics g);
}
