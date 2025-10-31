package _04_DesignPatterns.Behavioral.Strategy;

/*

    - CODE EXPLANATION:

    - CHALLENGE:
        - Let's consider an application that stores videos. Before storing a video, the video needs to be compressed using a specific compression algorithm such as MOV or MP4, then, if necessary apply an overlay of say black and white or blur to the video


    - SOLUTION 1: Conditional If else;
        - Compressors and Overlays enum:
            - We will be creating a VideoStorage class to handle the situation. First we create enums for the different types of Compressors and Overlays present
                - NOTE:
                    - Using enums is better than using hardcoded strings because it avoids typos plus makes it easy to edit

                public enum Compressors {

                    MOV, MP4, WEBM;
                }

                public enum Overlays {

                    None, BlackAndWhite, Blur;
                }


        - VideoStorage class:
            - We create the VideoStorage class, which has two fields: Compressors and Overlays
                public class VideoStorage {
                    private Compressors compressors;
                    private Overlays overlays;

                    ...
                }


            - We need a construtor to initialize the 2 fields we will be using
                    public class VideoStorage {
                        public VideoStorage(Compressors compressors, Overlays overlays) {
                            this.compressors = compressors;
                            this.overlays = overlays;
                        }

                        ...
                    }


            - We need a setters because once VideoStroage is created, we can change the Compression or Overlay algorithm used in the VideoStorage object to store the video differently
                    public class VideoStorage {
                        public void setCompressors(Compressors compressors) {
                            this.compressors = compressors;
                        }

                        public void setOverlays(Overlays overlays) {
                            this.overlays = overlays;
                        }

                        ...
                    }


            - Then we create store() method which contains our logic for storing the video, it takes a fileName and uses the current Compressor and Overlay from the client to store the video
                    public class VideoStorage {
                        public void store(String fileName) {

                            // Compression logic
                            if (compressors == Compressors.MOV) {
                                System.out.println("Compressing using MOV");
                            } else if (compressors == Compressors.MP4) {
                                System.out.println("Compressing using MP4");
                            } else if (compressors == Compressors.WEBM) {
                                System.out.println("Compressing using WEBM");
                            }

                            // Compression logic
                            if (overlays == Overlays.BlackAndWhite) {
                                System.out.println("Applying black and white on overlay");
                            } else if (overlays == Overlays.Blur) {
                                System.out.println("Applying blur overlay");
                            } else if (overlays == Overlays.None) {
                                System.out.println("Not applying any overlay");
                            }

                            // Storing
                            System.out.println("Storing video to " + fileName + "." + compressors);
                        }

                        ...
                    }


        - PROBLEMS:
            - This solution works great but has a couple of problems;
                1. It violates the Open/Closed Principle: If we want to add a new Compressor or Overlay, we need to modify the VideoStorage class
                2. The store() method is quite large and complex. If we add more Compressors or Overlays, it will get even larger and more complex
                3. The VideoStorage class is tightly coupled to the specific Compressor and Overlay implementations, making it difficult to test and maintain



    - SOLUTION 2: Strategy Pattern;
        - Compressor and Overlay interfaces;
            - First we create an interface for 2 of our strategies;
                public interface Compressor {
                    void compress();
                }

                public interface Overlay {
                    void apply();
                }


        - Compressors and Overlays Concrete classes;
            - Then we create 2 sets of concrete implementations(Compressors and Overlays)
                public class CompressorMP4 implements Compressor {
                    @Override
                    public void compress() {
                        System.out.println("Compressing using MP4");
                    }
                }

                public class OverlayBlackAndWhite implements Overlay {
                    @Override
                    public void apply() {
                        System.out.println("Applying black and white on overlay");
                    }
                }


        - VideoStorage class:
            - We then create our VideoStorage class, which has 2 fields: Compressor and Overlay interfaces rather than coding to enums
            - We need a constructor to create VideoStorage

                public class VideoStorage {

                    private Compressor compressor;

                    private Overlay overlay;

                    public VideoStorage(Compressor compressor, Overlay overlay) {
                        this.compressor = compressor;
                        this.overlay = overlay;
                    }

                    ...
                }


            - Our biggest changes now comes in the store() method. It's now much simpler because we delegate the work to concrete classes of Compressor and Overlay objects. This way VideoStorage has no knowledge for each compression and overlay algorithm
                - NOTES:
                    - In a real application you have to pass in the file name the compressor and overlay methods so they can work on the actual video file
                    - We also don't need to check for the compression algorithm or overlay type because the client has already passed in the correct concrete implementations of Compressor and Overlay that they want to use

                    public class VideoStorage {

                        public void store(String fileName) {

                            compressor.compress();
                            overlay.apply();
                            // Storing
                            System.out.println("Storing video to " + fileName + "." + compressor);
                        }

                        ...
                    }


        - Main class: Client;
            - Let's look at how clients will use the solution
                public class Main {
                    public static void main(String[] args) {

                        VideoStorage videoStorage = new VideoStorage(new CompressorMOV(), new OverlayBlackAndWhite());
                        videoStorage.store("/videos/some-movie");

                        ...
                    }
                }


            - Because we added setters to VideoStorage, we can change the compression and overlay algorithm at any time
                - It allows us to change the Compressor or Overlay we use within the VideoStorage class, we don't have to create a new VideoStorage object each time we want to change the compression algorithm or overlay
                    public class Main {
                        public static void main(String[] args) {

                            videoStorage.setCompressor(new CompressorMP4());
                            videoStorage.setOverlay(new OverlayBlur());
                            videoStorage.store("/videos/some-movie");

                            ...
                        }
                    }


        - Observation:
            - This solution offers several advantages over the previous one(If else staments):
                - It adheres to the Open/Closed Principle as we can add new Compressors and Overlays without modifying the VideoStorage class
                    - Example to create a new compressor we simply create a new class that implements the Compressor interface

 */

public class Explanation {
}
