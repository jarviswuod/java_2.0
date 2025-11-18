package _03_Design.Structural.Proxy;

/*

    NOTES:
    - 
    - 3 key players:
        - 
        - 
        - 


            public class Notes {
                public static void main(String[] args) {

                    VideoList videoList = new VideoList();
                    String[] videoIds = { "4321", "abcde123f", "javasc123" };

                    for (String videoId : videoIds) {
                        videoList.add(new YoutubeVideoProxy(videoId));
                        // videoList.add(new YoutubeVideo(videoId));
                    }

                    System.out.println();

                    videoList.watch("abcde123f");
                }
            }

            interface Video {

                void render();

                String getVideoId();
            }

            class YoutubeVideo implements Video {

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

            class YoutubeVideoProxy implements Video {

                private String videoId;
                private YoutubeVideo youtubeVideo;

                public YoutubeVideoProxy(String videoId) {
                    this.videoId = videoId;
                }

                @Override
                public void render() {
                    if (youtubeVideo == null)
                        youtubeVideo = new YoutubeVideo(videoId);

                    youtubeVideo.render();
                }

                @Override
                public String getVideoId() {
                    return videoId;
                }
            }

            class VideoList {

                private Map<String, Video> videoList = new HashMap<>();

                public void add(Video video) {
                    videoList.put(video.getVideoId(), video);
                }

                public void watch(String videoId) {
                    Video video = videoList.get(videoId);
                    video.render();
                }
            }


 */

public class Notes {
    public static void main(String[] args) {

    }
}
