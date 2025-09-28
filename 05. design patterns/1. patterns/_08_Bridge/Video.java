package _08_Bridge;

public abstract class Video {

    protected VideoProccesor videoProccesor;

    public Video(VideoProccesor videoProccesor) {
        this.videoProccesor = videoProccesor;
    }

    public abstract void play(String videoFile);
}
