package extensions;

import fsm.*;
import model.Direction;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

import static extensions.Knight.Event.*;
import static fsm.FiniteStateMachine.Transition.from;
import static utils.ImageStateUtils.imageStatesFromFolder;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Knight extends AbstractFixedSizeSprite {
    public enum Event {
        MOVE, STOP, ATTACK
    }

    private final FiniteStateMachine fsm;
    private final Set<Direction> directions = new HashSet<>();
    private Direction face = Direction.RIGHT;

    public Knight(Point location) {
        super(location, new Dimension(146, 176),
                new Dimension(15, 10), new Dimension(91, 153));
        fsm = new FiniteStateMachine();

        ImageRenderer imageRenderer = new KnightImageRenderer(this);
        State halting = new WaitingPerFrame(7,
                new Halting(imageStatesFromFolder("assets/halt", imageRenderer)));
        State moving = new WaitingPerFrame(5,
                new Moving(this, imageStatesFromFolder("assets/moving", imageRenderer)));
        State attacking = new WaitingPerFrame(10,
                new Attacking(fsm, imageStatesFromFolder("assets/attack", imageRenderer)));

        fsm.setInitialState(halting);
        fsm.addTransition(from(halting).when(MOVE).to(moving));
        fsm.addTransition(from(moving).when(STOP).to(halting));
        fsm.addTransition(from(halting).when(ATTACK).to(attacking));
        fsm.addTransition(from(moving).when(ATTACK).to(attacking));
        fsm.addTransition(from(attacking).when(STOP).to(halting));
    }

    public void attack() {
        fsm.trigger(ATTACK);
    }

    public void move(Direction direction) {
        if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            face = direction;
        }
        if (!directions.contains(direction)) {
            this.directions.add(direction);
            System.out.println("move");
            fsm.trigger(MOVE);
        }
    }

    public void stop(Direction direction) {
        directions.remove(direction);
        if (directions.isEmpty()) {
            fsm.trigger(STOP);
        }
    }

    public void update() {
        fsm.update();
    }

    @Override
    public void render(Graphics g) {
        fsm.render(g);
    }

    public Direction getFace() {
        return face;
    }

    public Set<Direction> getDirections() {
        return directions;
    }
}
