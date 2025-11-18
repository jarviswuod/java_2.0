package _04_DesignPatterns.Structural.Proxy.good;

// import _04_DesignPatterns.Structural.Proxy.good._3rdPartylibrary.YoutubeVideo;

public class Main {
    public static void main(String[] args) {

        VideoList videoList = new VideoList();
        String[] videoIds = { "4321", "abcde123f", "javasc123" };

        for (String videoId : videoIds) {
            // videoList.add(new YoutubeVideo(videoId));

            videoList.add(new YoutubeVideoProxy(videoId));
        }

        System.out.println();

        videoList.watch("abcde123f");
    }
}
