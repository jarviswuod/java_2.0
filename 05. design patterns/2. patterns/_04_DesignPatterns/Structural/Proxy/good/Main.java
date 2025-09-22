package _04_DesignPatterns.Structural.Proxy.good;

public class Main {
    public static void main(String[] args) {

        VideoList videoList = new VideoList();
        String[] videoIds = { "4321", "abcde123f", "javasc123" };

        for (String videoId : videoIds) {
            videoList.add(new YoutubeVideoProxy(videoId));
        }

        System.out.println();

        videoList.watch("abcde123f");
    }
}
