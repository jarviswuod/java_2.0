package _08_Bridge;

public class NetflixVideo extends Video {

    public NetflixVideo(VideoProccesor videoProccesor) {
        super(videoProccesor);
    }

    @Override
    public void play(String videoFile) {
        videoProccesor.process(videoFile);
    }
}
