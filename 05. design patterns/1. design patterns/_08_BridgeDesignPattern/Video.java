package _08_BridgeDesignPattern;

public abstract class Video {
    protected VideoProccesor videoProccesor;

    public Video(VideoProccesor videoProccesor) {
        this.videoProccesor = videoProccesor;
    }

    public abstract void play(String videoFile);
}
