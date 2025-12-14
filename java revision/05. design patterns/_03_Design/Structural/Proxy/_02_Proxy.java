package _03_Design.Structural.Proxy;

import java.util.HashMap;
import java.util.Map;

/*

    NOTES:
    - Is a structural design pattern that introduces an object to control access to another object
    - Key players:
        - Subject
        - Real subject
        - Proxy

    - Example:
        - YoutubeVideoAPI

*/

public class _02_Proxy {
    public static void main(String[] args) {

        String[] list = { "iojk", "09yu", "ascv", "jh76" };

        _02_VideoList videoList = new _02_VideoList();

        for (String id : list) {

            // videoList.add(new _02_YoutubeVideo(id));

            videoList.add(new _02_YoutubeVideoProxy(id));
        }

        System.out.println();

        videoList.render("jh76");
    }
}

interface _02_Video {

    String getVideoId();

    void render();

}

class _02_YoutubeVideo implements _02_Video {

    private String videoId;

    public _02_YoutubeVideo(String videoId) {
        if (videoId == null)
            throw new IllegalArgumentException("videoId cannot be null");

        this.videoId = videoId;
        download();
    }

    private void download() {
        System.out.println("Video downloaded successfully " + videoId);
    }

    public void render() {
        System.out.println("Rendering video with an id of " + videoId);
    }

    @Override
    public String getVideoId() {
        return videoId;
    }
}

class _02_YoutubeVideoProxy implements _02_Video {

    private String videoId;
    private _02_YoutubeVideo youtubeVideo;

    public _02_YoutubeVideoProxy(String videoId) {
        this.videoId = videoId;
    }

    public void render() {
        if (youtubeVideo == null)
            youtubeVideo = new _02_YoutubeVideo(videoId);

        youtubeVideo.render();
    }

    @Override
    public String getVideoId() {
        return videoId;
    }
}

class _02_VideoList {

    private Map<String, _02_Video> videos = new HashMap<>();

    public void add(_02_Video video) {

        videos.put(video.getVideoId(), video);
    }

    public void render(String videoId) {
        _02_Video video = videos.get(videoId);
        video.render();
    }
}
