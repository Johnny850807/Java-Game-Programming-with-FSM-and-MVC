package extensions;

import fsm.CyclicSequence;
import fsm.ImageState;
import fsm.Sequence;

import java.util.List;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Moving extends CyclicSequence {
    private final Knight knight;

    public Moving(Knight knight, List<ImageState> states) {
        super(states);
        this.knight = knight;
    }

    @Override
    public void update() {
        super.update();
        knight.getDirections()
                .forEach(direction -> direction.translate(knight.getLocation()));
    }

    @Override
    public String toString() {
        return "Moving";
    }
}
