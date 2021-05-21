package knight;

import fsm.Sequence;
import fsm.State;
import fsm.StateMachine;
import media.AudioPlayer;
import model.Sprite;
import model.World;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Attacking extends Sequence {
    public static final String AUDIO_SWORD_CLASH_1 = "sword-clash1";
    public static final String AUDIO_SWORD_CLASH_2 = "sword-clash2";
    private final Knight knight;
    private final StateMachine stateMachine;
    private final Set<Integer> damagingStateNumbers = new HashSet<>(List.of(6));

    public Attacking(Knight knight, StateMachine stateMachine, List<? extends State> states) {
        super(states);
        this.knight = knight;
        this.stateMachine = stateMachine;
    }

    @Override
    public void update() {
        if (knight.isAlive()) {
            super.update();
            if (damagingStateNumbers.contains(currentPosition)) {
                effectDamage();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
         Rectangle damageArea = damageArea();
         g.setColor(Color.BLUE);
         g.drawRect(damageArea.x, damageArea.y, damageArea.width, damageArea.height);
    }

    private void effectDamage() {
        World world = knight.getWorld();
        Rectangle damageArea = damageArea();
        var sprites = world.getSprites(damageArea);
        boolean hasClash = false;
        for (Sprite sprite : sprites) {
            if (knight != sprite) {
                sprite.onDamaged(damageArea, knight.getDamage());
                hasClash = true;
            }
        }
        if (hasClash) {
            AudioPlayer.playSounds(AUDIO_SWORD_CLASH_1);
        } else {
            AudioPlayer.playSounds(AUDIO_SWORD_CLASH_2);
        }
    }

    private Rectangle damageArea() {
        return knight.getArea(new Dimension(87, 70),
                new Dimension(55, 88));
    }

    @Override
    protected void onSequenceEnd() {
        currentPosition = 0;
        stateMachine.reset();
    }
}
