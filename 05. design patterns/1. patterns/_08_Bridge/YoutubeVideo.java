package _08_BridgeDesignPattern;

public class YoutubeVideo extends Video {

    public YoutubeVideo(VideoProccesor videoProccesor) {
        super(videoProccesor);
    }

    @Override
    public void play(String videoFile) {
        videoProccesor.process(videoFile);
    }

}
