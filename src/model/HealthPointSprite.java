package model;

import knight.HealthPointBar;
import media.AudioPlayer;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class HealthPointSprite extends Sprite {
    public static final String AUDIO_DIE = "Die";

    protected HealthPointBar hpBar;

    public HealthPointSprite(int hp) {
        this.hpBar = new HealthPointBar(hp);
        hpBar.setOwner(this);
    }

    @Override
    public void onDamaged(Rectangle damageArea, int damage) {
        hpBar.onDamaged(damageArea, damage);
        if (hpBar.isDead()) {
            world.removeSprite(this);
            AudioPlayer.playSounds(AUDIO_DIE);
        }
    }

    @Override
    public void render(Graphics g) {
        hpBar.render(g);
    }
}
