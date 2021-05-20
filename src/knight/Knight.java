package knight;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import model.Direction;
import model.HealthPointSprite;
import model.SpriteShape;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static fsm.FiniteStateMachine.Transition.from;
import static knight.Knight.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Knight extends HealthPointSprite {
    public static final int KNIGHT_HP = 500;
    private final SpriteShape shape;
    private final FiniteStateMachine fsm;
    private final Set<Direction> directions = new CopyOnWriteArraySet<>();
    private final int damage;

    public Knight(int damage, Point location) {
        super(KNIGHT_HP);
        this.damage = damage;
        this.location = location;
        shape = new SpriteShape(new Dimension(146, 176),
                new Dimension(33, 38), new Dimension(66, 105));
        fsm = new FiniteStateMachine();

        ImageRenderer imageRenderer = new KnightImageRenderer(this);
        State halting = new WaitingPerFrame(4,
                new Halting(imageStatesFromFolder("assets/halt", imageRenderer)));
        State moving = new WaitingPerFrame(2,
                new Moving(this, imageStatesFromFolder("assets/moving", imageRenderer)));
        State attacking = new WaitingPerFrame(3,
                new Attacking(this, fsm, imageStatesFromFolder("assets/attack", imageRenderer)));

        fsm.setInitialState(halting);
        fsm.addTransition(from(halting).when(MOVE).to(moving));
        fsm.addTransition(from(moving).when(STOP).to(halting));
        fsm.addTransition(from(halting).when(ATTACK).to(attacking));
        fsm.addTransition(from(moving).when(ATTACK).to(attacking));
    }

    public void attack() {
        fsm.trigger(ATTACK);
    }

    public int getDamage() {
        return damage;
    }

    public void move(Direction direction) {
        if (direction == LEFT || direction == Direction.RIGHT) {
            face = direction;
        }
        if (!directions.contains(direction)) {
            this.directions.add(direction);
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
        super.render(g);
        fsm.render(g);
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public Rectangle getRange() {
        return new Rectangle(location, shape.size);
    }

    @Override
    public Dimension getBodyOffset() {
        return shape.bodyOffset;
    }

    @Override
    public Dimension getBodySize() {
        return shape.bodySize;
    }

    public enum Event {
        MOVE, STOP, ATTACK, DAMAGED
    }

}
