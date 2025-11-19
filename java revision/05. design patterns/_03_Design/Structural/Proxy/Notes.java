package _03_Design.Structural.Proxy;

/*

    NOTES:
    - Is a structural pattern that provides an object to control access to another object allowing for additional functionality without affecting the original object code
    - 3 key players:
        - Subject interface
        - Real subject
        - Proxy


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


    -  REVISION::
        - Proxy design pattern:
            - Is a structural pattern that provides an object to control access to another object allowing for modifications without affecting original object
            - 3 Key players:
                - Subject
                - Real subject
                - Proxy


                        public class Notes {
                            public static void main(String[] args) {

                                VideoList videoList = new VideoList();
                                String[] ids = { "adbde", "fedbq", "abc123", "zbcvt2" };

                                for (String id : ids) {
                                    // videoList.add(new YoutubeVideo(id));

                                    videoList.add(new YoutubeVideoProxy(id));
                                }

                                System.out.println();

                                videoList.watch("adbde");
                                videoList.watch("adbde");
                            }
                        }

                        interface Video {

                            String videoId();

                            void render();
                        }

                        class VideoList {

                            private Map<String, Video> list = new HashMap<>();

                            public void add(Video video) {
                                list.put(video.videoId(), video);
                            }

                            public void watch(String videoId) {
                                Video video = list.get(videoId);
                                video.render();
                            }
                        }

                        class YoutubeVideoProxy implements Video {

                            private String videoId;
                            private YoutubeVideo youtubeVideo;

                            public YoutubeVideoProxy(String videoId) {
                                this.videoId = videoId;
                            }

                            public String getVideoId() {
                                return videoId;
                            }

                            @Override
                            public String videoId() {
                                return videoId;
                            }

                            @Override
                            public void render() {
                                if (youtubeVideo == null)
                                    youtubeVideo = new YoutubeVideo(videoId);

                                youtubeVideo.render();
                            }
                        }

                        class YoutubeVideo implements Video {

                            String videoId;

                            public YoutubeVideo(String videoId) {
                                this.videoId = videoId;
                                download();
                            }

                            private void download() {
                                System.out.println("Downloading Video with id of " + videoId);
                            }

                            public String getVideoId() {
                                return videoId;
                            }

                            @Override
                            public String videoId() {
                                // System.out.println("IDK");
                                return videoId;
                            }

                            @Override
                            public void render() {
                                System.out.println("Rendering video with id " + videoId + " to screen");
                            }
                        }

 */

public class Notes {
    public static void main(String[] args) {

    }
}
