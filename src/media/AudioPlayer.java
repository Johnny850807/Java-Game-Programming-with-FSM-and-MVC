package media;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class AudioPlayer {
    private static final Map<Object, File> sounds = new HashMap<>();

    public static void addAudioByFilePath(Object audioName, File file) {
        sounds.put(audioName, file);
    }

    public static void addAudioByFilePath(Object audioName, String path) {
        sounds.put(audioName, Paths.get(path).toFile());
    }

    public static void playSounds(Object audioName) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sounds.get(audioName)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
