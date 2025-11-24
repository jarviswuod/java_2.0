package _04_DesignPatterns.Structural.Adapter;

/*

    CODE EXPLANATION:

    - CHALLENGE:
        - Say we have a video editing application that allows users to upload a video and change the color of the video. The application provides preset color options for the user to select, such as black and white or midnight purple
        - We then decide to install a 3rd-party library into our application that allows users to apply more types of colors to their videos
        - We cannot modify the 3rd-party library code to make the color classes implement Color interface



    - SOLUTION 1
        - Video class:
            - This class represents some sort of video. It's just a base class with no fields or methods

                    public class Video {

                        // video fields and methods
                    }


        - Color interface:
            - We have color interface which has apply() method which takes in a Video on which we will apply the color to

                    public interface Color {

                        void apply(Video video);
                    }


        - Concrete Color classes:
            - BlackAndWhite:
                - This class implements Color interface thereby implementing the apply() method which accepts a Video to apply the blackAndWhite color to
                - NOTE:
                    - In a real aplication this would be some complex code to apply a blackAndWhite color to Video

                    public class BlackAndWhite implements Color {

                        @Override
                        public void apply(Video video) {
                            System.out.println("Applying black and white to video");
                        }
                    }


            - Midnight:
                - Same concepts in BlackAndWhite class apply here

                    public class Midnight implements Color {

                        @Override
                        public void apply(Video video) {
                            System.out.println("Applying Midnight-purple to the video");
                        }
                    }


        - VideoEditor class:
            - Our VideoEditor class has a Video field that we'll pass to the VideoEditor constructor
            - We have applyColor() method which accepts Color object and then calls apply() passing the video we want to apply the color to

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
            - First, create a VideoEditor object passing Video object we want editted then call the applyColor() method passing any Color object we want applied

                    public class Main {
                        public static void main(String[] args) {

                            VideoEditor videoEditor = new VideoEditor(new Video());
                            videoEditor.applyColor(new BlackAndWhite()); // Applying black and white to video
                        }
                    }


        - PROBLEM:
            - The code works good until we decide to install a 3rd party library to work with our application. One that allows users apply more types of colors to their video




    - SOLUTION 2: ADAPTER PATTERN
        - We can solve this issue by converting the interface of the 3rd party color classes to a different form using the Adapter Pattern


        - Video class:
            - This is a class that represents some sort of Video
                    public class Video {

                        // video fields and methods
                    }


        - Color interface:
            - It describes what a concrete Color class should look like implementing apply() method which accepts a Video object
                    public interface Color {

                        void apply(Video video);
                    }


        - Concrete Classes:
            - They implement Color interface and have an apply() method one that takes a Video object and applys color to it
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
            - Our VideoEditor class has a Video field and we pass a Video to the editor via a constructor
            - Then we have applyColor() method which takes in Color object and then calls color.apply() passing the video we want to apply color to
                    public class VideoEditor {

                        private Video video;

                        public VideoEditor(Video video) {
                            this.video = video;
                        }

                        public void applyColor(Color color) {

                            color.apply(video);
                        }
                    }


        - _3rdPartyLibrary/ Rainbow class:
            - This is Color class from the 3rd party library
            - Let's say colors from this 3rd party library requires some kind of setup hence we have to call the setUp() method before we use the library
                - NOTE:
                    - This can be some kind of method that we could pass some configurations options such as color brightness or whatnot. In our case we'll leave it simple by logging "Setting up rainbow filter"

            -  Then we create an update() method which is similar to our apply() method. This means the 3rd party calls will be made by calling update() method while we'll call the apply() method for the same functionality

                    public class Rainbow {

                        public void setUp() {
                            System.out.println("Setting up rainbow filter");
                        }

                        public void update(Video video) {
                            System.out.println("Applying rainbow filter to video");
                        }
                    }

            - This class represents our 3rd party Rainbow color class but we are unable to use it because it doesn't implement our Color interface
            - We have to create an Adapter class that adapts this Rainbow class to use our color interface so it can be used by our VideoEditor class without having to modify the Rainbow (3rd party) class source code



        - RainbowColorComposition class:
            - This is one of our own custom Color class and not part of the 3rd party installed package
            - It implements our Color interface and Stores a field of type Rainbow (composition) i.e RainbowColorComposition class is composed of or has a Rainbow object
            - We will also create constructor where we'll pass the Rainbow object
            - In our apply() method we can interact with our 3rd party Rainbow object by calling rainbow.setUp(). This is something that the 3rd party library requires us to do so we can call the update() method and pass the video
            - In summary we have a RainbowColorComposition class that implements our Color interface and we can now pass it to our VideoEditor's class applyColor() method then use the 'adapted' RainbowColorComposition as we would with any of our own color classes. i.e We can now apply the RainbowColor (from the 3rd party library) just like we can with our own custom concrete Color classes say BlackAndWhite or Midnight
                    public class RainbowColorComposition implements Color {

                        private Rainbow rainbow;

                        public RainbowColorComposition(Rainbow rainbow) {
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
            - We see if we can apply RainbowColorComposition class in which we pass the Rainbow class object(from our 3rd party)
            - NOTE:
                - RainbowColorComposition class is a wrapper that translates one interface into another and to use any other color from the 3rd party library we can create a new wrapper class or adapter class to make it compatible with VideoEditor class satisfying the OCP

                    public class Main {
                        public static void main(String[] args) {

                            VideoEditor videoEditor = new VideoEditor(new Video());

                            videoEditor.applyColor(new BlackAndWhite());
                            System.out.println();

                            videoEditor.applyColor(new RainbowColorInheritance());
                            System.out.println();

                            videoEditor.applyColor(new RainbowColorComposition(new Rainbow()));
                        }
                    }


        - RainbowColorInheritance class:
            - We can also use inheritance to create our Adapter class
            - Here we implement the Color interface and extend the Rainbow class

                    public class RainbowColorInheritance extends Rainbow implements Color {

                        @Override
                        public void apply(Video video) {
                            setUp();
                            update(video);
                        }
                    }

            - Pay attention to the difference in how we implement the apply() method, under RainbowColorComposition class is composed of Rainbow object we have to call the methods [[rainbow.setUp() & rainbow.update(video)]] on this Rainbow object that we passed into RainbowColorComposition whereas under RainbowColorInheritance we can call the methods [[setUp() & update(video)]] directly because we've inherited both Rainbow class and Color interface from which both setUp() and update() methods are implemented already we can just call them directly

            - Both adapters (composition & inheritance) do the same thing. The only problem with inheritance is that it's not as flexible as using composition because we're limited to extending only one class

 */

public class Explanation {

}