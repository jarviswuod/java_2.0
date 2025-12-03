package _03_Design.Structural.Proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    NOTES:
    - Is a structural design pattern that introduces an object to control access to another object. This allows for additional fucntionalities such as caching, lazy loading, resource management, access control and logging
    - Key players:
        - Subject
        - Real Subject
        - Proxy

    - Example:
        - YoutubeDownloadProxy

*/

class VideoList {

    private Map<String, Video> videos = new HashMap<>();

    public void add(Video video) {
        videos.put(video.videoId(), video);
    }

    public void watch(String videoId) {
        Video video = videos.get(videoId);
        video.render();
    }
}

public class _01_Proxy {
    public static void main(String[] args) {

        VideoList videoList = new VideoList();

        List<String> videoIds = List.of("123bd", "ilkinj", "po9009", "qwsa");

        for (String videoId : videoIds) {
            // videoList.add(new YoutubeDownloader(videoId));

            videoList.add(new YoutubeDownloaderProxy(videoId));
        }

        System.out.println();
        videoList.watch("123bd");
        videoList.watch("123bd");
    }
}

class _01_Proxy_ {
    public static void main(String[] args) {

        Map<String, Video> videoList = new HashMap<>();

        List<String> videoIds = List.of("123bd", "ilkinj", "po9009", "qwsa");

        for (String videoId : videoIds) {
            // videoList.put(videoId, new YoutubeDownloader(videoId));

            videoList.put(videoId, new YoutubeDownloaderProxy(videoId));
        }

        Video video = videoList.get("123bd");
        video.render();
    }
}

interface Video {
    void render();

    String videoId();
}

class YoutubeDownloader implements Video {

    private String videoId;

    public YoutubeDownloader(String videoId) {
        this.videoId = videoId;
        download();
    }

    private void download() {
        System.out.println("Downloading Video from youtube API: " + videoId);
    }

    @Override
    public void render() {
        System.out.println("Rendering video with id of : " + videoId);
    }

    @Override
    public String videoId() {
        return videoId;
    }
}

class YoutubeDownloaderProxy implements Video {

    private String videoId;
    private YoutubeDownloader youtubeDownloader;

    public YoutubeDownloaderProxy(String videoId) {
        this.videoId = videoId;
    }

    private void download() {
        System.out.println("Downloading Video from youtube API: " + videoId);
    }

    @Override
    public void render() {
        if (youtubeDownloader == null)
            youtubeDownloader = new YoutubeDownloader(videoId);
        youtubeDownloader.render();
    }

    @Override
    public String videoId() {
        return videoId;
    }
}
