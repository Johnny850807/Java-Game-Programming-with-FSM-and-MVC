package views;

import controller.Game;
import controller.GameLoop;
import model.Direction;
import model.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collection;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class GameView extends JFrame {
    public static final int HEIGHT = 500;
    public static final int WIDTH = 500;
    private final Canvas canvas = new Canvas();
    private final Game game;

    public GameView(Game game) throws HeadlessException {
        this.game = game;
        game.setView(canvas);
    }

    public void launch() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(canvas);
        setSize(WIDTH, HEIGHT);
        setContentPane(canvas);
        setVisible(true);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_W:
                        game.moveKnight(Direction.UP);
                        break;
                    case KeyEvent.VK_S:
                        game.moveKnight(Direction.DOWN);
                        break;
                    case KeyEvent.VK_A:
                        game.moveKnight(Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        game.moveKnight(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_P:
                        game.attack();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_W:
                        game.stopKnight(Direction.UP);
                        break;
                    case KeyEvent.VK_S:
                        game.stopKnight(Direction.DOWN);
                        break;
                    case KeyEvent.VK_A:
                        game.stopKnight(Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        game.stopKnight(Direction.RIGHT);
                        break;
                }
            }
        });
    }

    public static class Canvas extends JPanel implements GameLoop.View {
        private Collection<Sprite> sprites;

        @Override
        public void render(Collection<Sprite> sprites) {
            this.sprites = sprites;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, GameView.WIDTH, GameView.HEIGHT);
            for (Sprite sprite : sprites) {
                sprite.render(g);
            }
        }
    }
}
