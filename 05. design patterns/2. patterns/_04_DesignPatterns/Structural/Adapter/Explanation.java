package _04_DesignPatterns.Structural.Adapter;

/*

    CODE EXPLANATION:

    - CHALLENGE:
        - Say we have a video editing application that allows users to upload a video and change the color of the video. The application provides preset color options for the user to select, such as black and white or midnight purple
        - We then decide to install a 3rd-party library into our application that allows users to apply more types of colors to their videos
        - We cannot modify the 3rd-party library code to make the color classes implement Color interface



    - SOLUTION 1
        - Video class;
            - Just a base class with no fields or methods. This class represents some sort of Video

                    public class Video {

                        // video fields and methods
                    }


        - Color interface;
            - We have color interface which has apply() method which takes in a Video class. A video we gonna work on basically this is a Video on which we will apply color to

                    public interface Color {

                        void apply(Video video);
                    }


        - Concrete Color classes:
            - BlackAndWhiteColor:
                - It implements the Color interface and therefore overrides the apply() method which accepts a VIdeo to apply the black and white color to
                - NOTE: In a real aplication this would be some complex code to apply a black and white color to Video

                    public class BlackAndWhite implements Color {

                        @Override
                        public void apply(Video video) {
                            System.out.println("Applying black and white to video");
                        }
                    }


            - MidNightColor:
                - Same concepts applys here

                    public class Midnight implements Color {

                        @Override
                        public void apply(Video video) {
                            System.out.println("Applying Midnight-purple to the video");
                        }
                    }


        - VideoEditor class:
            - Our VideoEditor class has a VIdeo field and we pass a Video to the editor via a Constructor and then we have applyColor which takes some sort of Color object and then calls color.apply() passing the video that we want to apply the color to

                    public class VideoEditor {

                        private Video video;

                        public VideoEditor(Video video) {
                            this.video = video;
                        }

                        public void applyColor(Color color) {

                            color.apply(video);
                        }
                    }


        - Main class: Client class;
            - Here we create a VideoEditor object passing the Video we want to edit and then we call the VideoEditor.applyColor() method  and we pass any color Object methos that we want to apply to

                    public class Main {
                        public static void main(String[] args) {

                            VideoEditor videoEditor = new VideoEditor(new Video());
                            videoEditor.applyColor(new BlackAndWhite()); // Applying black and white to video
                        }
                    }


        - PROBLEM:
            - The code is working good so far, until we decide to install a 3rd party library into our application that allows users to apply more types of colors to their videos



    - SOLUTION 2: ADAPTER PATTERN
        - We can solve this issue by converting the interface of 3rd party color classes to a different form using the Adapter Pattern


        - Video class:
            - This is a class that represents a some sort of Video
                    public class Video {

                        // video fields and methods
                    }


        - Color interface:
            - It describes what a concrete color class should look like and all colors should apply the apply() method that accepts a Video object
                    public interface Color {

                        void apply(Video video);
                    }


        - Concrete Classes:
            - We have concrete classes such as blackAndWhite which implement the color interface and have an apply() method that takes a video than the method applies the color to the VIdeo
                    public class BlackAndWhite implements Color {

                        @Override
                        public void apply(Video video) {
                            System.out.println("Applying black and white to video");
                        }
                    }

                    public class Midnight implements Color {

                        @Override
                        public void apply(Video video) {
                            System.out.println("Applying Midnight-purple to the video");
                        }
                    }


        - VideoEditor class:
            - It has a Video field which stores a video to a video to edit and it;s passed via the constructor and we have a applyColor() method where we can pass a color that we want to apply to the Video
                    public class VideoEditor {

                        private Video video;

                        public VideoEditor(Video video) {
                            this.video = video;
                        }

                        public void applyColor(Color color) {

                            color.apply(video);
                        }
                    }


        - _3rdPartyLibrary/Rainbow class:
            - This is VideoClass from the 3rd party library
            - Lets say colors from this 3rd party library requires some kind of setup hence we have to call the setUp() method before we use the library.
                - NOTE:
                    - This can be some kind of methos that we could pass some configurations options such as brightness of the color or whatnot, but in our case will leave it empty and a simple method logging in "Setting up filter"

            -  Then we will create a method called update() which will be basically a kinda similar method to our apply() method. so the 3rd party calls the method update() while we call the method apply() same functionality. And it applies the Color to the video
            - This class represents our 3rd party Rainbow color class looks like and currently we cannot use this because it doesn't implement the color interface, so what we can now do is create an adapter class that adapts this rainbow class to use our color interface so it can be used by our VideoEditor class without having to modify the Rainbow class source code(3rd party source code)
                    public class Rainbow {

                        public void setUp() {
                            System.out.println("Setting up rainbow filter");
                        }

                        public void update(Video video) {
                            System.out.println("Applying rainbow filter to video");
                        }
                    }


        - RainbowColor class:
            - This is one of our own custom color class and not part of the installed package class
            - It implements our Color interface and Stores a field of type Rainbow, this is composition, i.e RainbowColor class is composed of or has a Rainbow object
            - We will also create constructor where we will pass the Rainbow object and in our apply() method,  we can interact with our 3rd party Rainbow object - rainbow.setUp() - this is something that the 3rd party Library requires us to do so we can call the update() method and pass the video
            - In summary we have a RainCOlor class that implements the Color interface and we can now pass our VideoEditor class method applyColor() and use the Rainbow color as we would with any of our own  color classes, so we can now apply the Rainbow color(from the 3rd party library) just like the  other classes
                    public class RainbowColor_Composition implements Color {

                        private Rainbow rainbow;

                        public RainbowColor_Composition(Rainbow rainbow) {
                            this.rainbow = rainbow;
                        }

                        @Override
                        public void apply(Video video) {
                            rainbow.setUp();
                            rainbow.update(video);
                        }
                    }



        - Main class: Client class;
            - We are in our Main class to test if we can use our Rainbow color just like other colors we have 
            - We see if we can apply RainbowCOlor class in which we pass the Rainbow class object
                - NOTE: RainbowColor class is a wrapper that translates one interface into another and to use any other color from the 3rd party library we can create a new wrapper class or adapter class to make it compatible with VideoEditor class satisfying the OCP

                    public class Main {
                        public static void main(String[] args) {

                            VideoEditor videoEditor = new VideoEditor(new Video());

                            videoEditor.applyColor(new BlackAndWhite());
                            System.out.println();

                            videoEditor.applyColor(new RainbowAdapter_Inheritance());
                            System.out.println();

                            videoEditor.applyColor(new RainbowColor_Composition(new Rainbow()));
                        }
                    }


        - RainbowAdapter class:
            - We can also use Inheritance to create our Adapter class
            - Here we implement the Color interface and extend the Rainbow class

                    public class RainbowAdapter_Inheritance extends Rainbow implements Color {

                        @Override
                        public void apply(Video video) {
                            setUp();
                            update(video);
                        }
                    }

            - Pay attention to the difference in how we implement the apply() method, under RainbowColor class is composed on Rainbow object we hav eto call the methods on 'the/this' Rainbow object that we passed into RainbowColor whereas under RainbowAdapter we can call the methods directly because there have been  inherited by the Rainbow class we extended from (it has a setUp method and an updaet() method) and we inheriting them so we can just call them directly

            - Both adapters composition and inheritance do the same thing, the problem with inheritance approach is that it's not as flexible as using the composition one because we can only extend one class. Composition on the other has is very flexible

 */

public class Explanation {

}