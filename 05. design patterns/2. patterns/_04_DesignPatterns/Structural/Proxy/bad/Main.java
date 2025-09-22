package _04_DesignPatterns.Structural.Proxy.bad;

import _04_DesignPatterns.Structural.Proxy.bad._3rdPartylibrary.YoutubeVideo;

public class Main {
    public static void main(String[] args) {

        VideoList videoList = new VideoList();
        String[] videoIds = { "1234", "abcde", "javasc123" };

        for (String videoId : videoIds) {
            videoList.add(new YoutubeVideo(videoId));
        }

        System.out.println();

        videoList.watch("abcde");
    }
}
