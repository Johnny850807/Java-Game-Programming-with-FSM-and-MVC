package knight;

import model.CollisionHandler;
import model.Sprite;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class KnightCollisionHandler implements CollisionHandler {
    @Override
    public void handle(Point originalLocation, Sprite from, Sprite to) {
        if (from instanceof Knight && to instanceof Knight) {
            Rectangle body = from.getBody();
            int offsetLeft = to.getX() - body.x;
            int offsetRight = body.x + body.width - to.getX();
            if (offsetLeft < 0) {
                to.setLocation(new Point(to.getX() - (to.getRange().width + offsetLeft) / 3, to.getY()));
            } else {
                to.setLocation(new Point(to.getX() + offsetRight / 3, to.getY()));
            }

        }
    }
}
