package knight;

import fsm.CyclicSequence;
import fsm.ImageState;
import model.Direction;

import java.util.List;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Walking extends CyclicSequence {
    public static final String AUDIO_STEP1 = "step1";
    public static final String AUDIO_STEP2 = "step2";
    private final Knight knight;

    public Walking(Knight knight, List<ImageState> states) {
        super(states);
        this.knight = knight;
    }

    @Override
    public void update() {
        if (knight.isAlive()) {
            super.update();
            for (Direction direction : knight.getDirections()) {
                knight.getWorld().move(knight, direction.translate());
            }
        }
    }

    @Override
    public String toString() {
        return "Walking";
    }
}
