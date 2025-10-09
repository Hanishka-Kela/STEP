interface Playable { void play(); void pause(); }

class MusicPlayer implements Playable {
    public void play() { System.out.println("Music playing"); }
    public void pause() { System.out.println("Music paused"); }
}

class VideoPlayer implements Playable {
    public void play() { System.out.println("Video playing"); }
    public void pause() { System.out.println("Video paused"); }
}

public class PlayableTest {
    public static void main(String[] args) {
        Playable p = new MusicPlayer();
        p.play();
        p.pause();
        p = new VideoPlayer();
        p.play();
        p.pause();
    }
}