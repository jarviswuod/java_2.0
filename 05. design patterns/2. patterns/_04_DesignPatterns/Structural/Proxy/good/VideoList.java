package _04_DesignPatterns.Structural.Proxy.good;

import java.util.HashMap;
import java.util.Map;

import _04_DesignPatterns.Structural.Proxy.good._3rdPartylibrary.Video;

public class VideoList {

    private Map<String, Video> videoList = new HashMap<>();

    public void add(Video video) {
        videoList.put(video.getVideoId(), video);
    }

    public void watch(String videoId) {
        Video video = videoList.get(videoId);
        video.render();
    }
}
