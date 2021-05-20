package knight;

import fsm.CyclicSequence;
import fsm.ImageState;

import java.util.List;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Halting extends CyclicSequence {
    public Halting(List<ImageState> states) {
        super(states);
    }

    @Override
    public String toString() {
        return "Halting";
    }
}
