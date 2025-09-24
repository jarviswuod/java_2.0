package _04_DesignPatterns.Structural.Proxy;

/*

    CODE EXPLANATION:

    - CHALLENGE:
        - Let's say that we have an application that fetched a list of youtube videos from Youtube's API, and displays them in a list. In our application we are using a 3rd party youtube package to handle fetching youtube videos from the API, and then rendering the video on the screen with the video controls
        - The problem is that every time a request is made to our appilcation, our server has to re-download the video from the YouTube API. This takes a long time, especially if lots of requests are made to our application at once



    - SOLUTION 1:
        - 3rd party CODE:
            - Video Interface:
                - Here is the interface for what a Video object would look like from our 3rd party video library from youtube
                - We have a render() as well as a getVideo Id which returns a String ID of video
                - NOTE: from the 3rd party package

                    public interface Video {

                        void render();
                        String getVideoId();
                    }


            - YoutubeVideo class:
                - In the 3rd party package, we also have YoutubeVideo class which essentially create youtube video objects by fetching the video from the youtube API via it's 'videoId' which we pass inside the constructor o which the video starts to download by calling the download() whenever we create a new Youtube video object

                - We also have the render() method for rendering the video onto the UI

                - We also have the getVideo() method for getting video ID

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



        - OUR CODE:
            - VideoList class:
                - We have a Map to store a list of videos
                - We have add() for adding a video to the map
                - We have a method called watch() which takes in a videoId then gets a video from the Map list and then we call video.render()

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



        - Main class: Client class;
            - First we create a VideoList object then
            - We create a list of videoIds
            - Add then we loop through the videoIds and add them to our VideoList. REM; the YoutubeVideo class downloads a video when an object is created
            - Then we can watch a video by calling the videoList.watch() method passing an Id of the video we want to watch

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



        - PROBLEM:
            - Just adding a video to a videoList causes that whole video to be downloaded even if the user  doesn't want to watch that video the video will still be downaloaded keep in mind the user wants to watch the video with an ID "abcde" - it would be so much more efficient to download the video only after the user selected the video form the videoList, this is called lazy loading or delaying the loading of something for when it's actually required
            - The issue here however is our YoutubeVideo class is from a 3rd party library so we are unable to download teh source code the solution therefore is using a Proxy object which we create ourselves



    - SOLUTION 2: PROXY PATTERN:
        - YoutubeVideoProxy class;
            - It implements the Video interface from our 3rd party library
            - We need a couple of fields;
                - videoId field
                - YoutubeVideo - storing reference to the actual YoutubeVideo from our 3rd party library
            - Then we create a constructor passing in the videoId for the Video we want downloaded to watch
            - Then we need to implement the getVideoId() and render() methods
            - Inside render we want to lazy load the YoutubeVideo; what we do is to add a check to see if the Youtube video equals null only then do we set the Youtube video equals to a new YoutubeVIdeo passing the videoId of the video we want to watch;;; this means essentially if the render() methods is called multiple times it's still gonna download the YoutubeVideo once because it creates the YoutubeVideo one time... After this we call the youtubeVideo.render() method

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



        - Main class: Client class;
            - Now that we have the VideoProxy  objects that implement video we can now in our clients, we can add the Proxy objects in place of the real youtubeVideo class i.e;

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



            - BEFORE::
                for( Video videoId : videoIds) {
                    videoList.add(new YoutubeVideo(videoId));
                }
                videoList.watch("abcde");


            - AFTER::
                for( Video videoId : videoIds) {
                    videoList.add(new YoutubeVideoProxy(videoId));
                }
                videoList.watch("abcde");

            - NOTE: Only that small change is needed, changing the YoutubeVideo to YoutubeVideoProxy and our videoList does not care whether we have real YoutubeVideo or Proxy video because as far as videoList is concerned they both implement the third party Video interface and it can treat them the same using polymorphism

        - OBSERVATION:
            - When we run the program, we cna see that only one video of the videoId we passed is the only one being downloaded from the YoutubeAPI and video is rendered but if we comment out videoList.watch() method then nothing is logged to the console even when we add videos to the videoList this is opposed to what we had before

 */

public class Explanation {

}