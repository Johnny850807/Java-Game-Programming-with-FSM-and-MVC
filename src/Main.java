import controller.Game;
import knight.Attacking;
import knight.Knight;
import knight.KnightCollisionHandler;
import knight.Moving;
import model.HealthPointSprite;
import model.World;
import views.GameView;

import java.awt.*;
import java.io.File;

import static media.AudioPlayer.addAudioByFilePath;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Main {
    public static void main(String[] args) {
        addAudioByFilePath(Moving.AUDIO_STEP1, new File("assets/audio/step1.wav"));
        addAudioByFilePath(Moving.AUDIO_STEP2, new File("assets/audio/step2.wav"));
        addAudioByFilePath(Attacking.AUDIO_SWORD_CLASH_1, new File("assets/audio/sword-clash1.wav"));
        addAudioByFilePath(Attacking.AUDIO_SWORD_CLASH_2, new File("assets/audio/sword-clash2.wav"));
        addAudioByFilePath(HealthPointSprite.AUDIO_DIE, new File("assets/audio/die.wav"));

        Knight p1 = new Knight(100, new Point(0, 0));
        Knight p2 = new Knight(150, new Point(300, 300));
        World world = new World(new KnightCollisionHandler(), p1, p2);
        Game game = new Game(world, p1, p2);
        GameView view = new GameView(game);
        game.start();
        view.launch();
    }
}
