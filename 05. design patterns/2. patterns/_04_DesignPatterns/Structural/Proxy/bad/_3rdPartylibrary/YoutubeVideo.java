package _04_DesignPatterns.Structural.Proxy.bad._3rdPartylibrary;

public class YoutubeVideo implements Video {

    private String videoId;

    public YoutubeVideo(String videoId) {
        this.videoId = videoId;
        download();
    }

    public void download() {
        System.out.println("Downloading video with id " + videoId + " from youtube API");
    }

    @Override
    public void render() {
        System.out.println("Rendering video " + videoId);
    }

    @Override
    public String getVideoId() {
        return videoId;
    }
}
