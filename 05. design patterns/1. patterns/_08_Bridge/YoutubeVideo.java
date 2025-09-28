package _08_Bridge;

public class YoutubeVideo extends Video {

    public YoutubeVideo(VideoProccesor videoProccesor) {
        super(videoProccesor);
    }

    @Override
    public void play(String videoFile) {
        videoProccesor.process(videoFile);
    }
}
