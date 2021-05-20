package controller;

import extensions.Knight;
import model.Sprite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class GameLoop {
    private boolean running;
    private View view;

    public void setView(View view) {
        this.view = view;
    }

    public void start() {
        new Thread(this::gameLoop).start();
    }

    private void gameLoop() {
        running = true;
        while (running) {
            var sprites = getSprites();
            for (Sprite sprite : sprites) {
                sprite.update();
            }
            view.render(sprites);
            delay(15);
        }
    }

    protected abstract Collection<Sprite> getSprites();

    public void stop() {
        running = false;
    }

    private void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public interface View {

        void render(Collection<Sprite> sprites);
    }
}
