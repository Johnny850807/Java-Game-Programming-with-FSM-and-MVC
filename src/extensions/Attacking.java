package extensions;

import fsm.Sequence;
import fsm.State;
import fsm.StateMachine;

import java.util.List;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Attacking extends Sequence {
    private final StateMachine stateMachine;

    public Attacking(StateMachine stateMachine, List<? extends State> states) {
        super(states);
        this.stateMachine = stateMachine;
    }

    @Override
    protected void onSequenceEnd() {
        stateMachine.trigger(Knight.Event.STOP);
        currentPosition = 0;
    }
}
