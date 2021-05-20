package fsm;

import java.awt.*;
import java.util.List;

/**
 * The sequential gallery, it requires the resource homePath where the images are located.
 * The sequence will contain all the images in the homePath directory, it expects all the image file names
 * are in number form, (e.g. 0.png, 1.png, 2.png,...), so that it can determine the sequence order (ascending).
 *
 * @author johnny850807 (waterball)
 */
public abstract class Sequence implements State {
    protected final List<? extends State> states;
    protected int currentPosition;

    public Sequence(List<? extends State> states) {
        this.states = states;
    }

    @Override
    public void update() {
        currentPosition++;
        if (currentPosition >= states.size()) {
            onSequenceEnd();
        }
    }

    @Override
    public void render(Graphics g) {
        states.get(currentPosition).render(g);
    }

    protected abstract void onSequenceEnd();

}
