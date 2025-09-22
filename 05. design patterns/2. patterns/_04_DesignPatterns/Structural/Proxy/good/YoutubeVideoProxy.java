package _04_DesignPatterns.Structural.Proxy.good;

import _04_DesignPatterns.Structural.Proxy.good._3rdPartylibrary.YoutubeVideo;
import _04_DesignPatterns.Structural.Proxy.good._3rdPartylibrary.Video;

public class YoutubeVideoProxy implements Video {

    private String videoId;

    private YoutubeVideo youtubeVideo;

    public YoutubeVideoProxy(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public void render() {
        if (youtubeVideo == null) {
            youtubeVideo = new YoutubeVideo(videoId);
        }

        youtubeVideo.render();
    }

    @Override
    public String getVideoId() {
        return videoId;
    }
}
