package fsm;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class WaitingPerFrame implements State {
    private final State state;
    private final long waitingLoopPerFrame;
    private long remaining;

    public WaitingPerFrame(long waitingLoopPerFrame, State state) {
        this.remaining = this.waitingLoopPerFrame = waitingLoopPerFrame;
        this.state = state;
    }

    @Override
    public void update() {
        if (--remaining <= 0) {
            remaining = waitingLoopPerFrame;
            state.update();
        }
    }

    @Override
    public void render(Graphics g) {
        state.render(g);
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
