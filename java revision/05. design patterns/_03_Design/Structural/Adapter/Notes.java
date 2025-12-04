package _03_Design.Structural.Adapter;

/*

    NOTES:
    - Is a structural pattern that allows objects with incompatible to communicater by a providing a bridge

    - 3 key players:
        - Target
        - Adapter
        - Adaptee

                public class Notes {
                    public static void main(String[] args) {

                        VideoEditor videoEditor = new VideoEditor(new Video());

                        videoEditor.applyColor(new BlackAndWhite());
                        System.out.println();

                        videoEditor.applyColor(new RainbowColorInheritance());
                        System.out.println();

                        videoEditor.applyColor(new Midnight());
                        System.out.println();

                        videoEditor.applyColor(new RainbowColorComposition(new Rainbow()));
                    }
                }

                class Video {

                    // video fields and methods
                }

                interface Color {

                    void apply(Video video);
                }

                class BlackAndWhite implements Color {

                    @Override
                    public void apply(Video video) {
                        System.out.println("Applying black and white to video");
                    }
                }

                class Midnight implements Color {

                    @Override
                    public void apply(Video video) {
                        System.out.println("Applying Midnight-purple to the video");
                    }
                }

                class VideoEditor {

                    private Video video;

                    public VideoEditor(Video video) {
                        this.video = video;
                    }

                    public void applyColor(Color color) {

                        color.apply(video);
                    }
                }

                class Rainbow {

                    public void setUp() {
                        System.out.println("Setting up rainbow filter");
                    }

                    public void update(Video video) {
                        System.out.println("Applying rainbow filter to video");
                    }
                }

                class RainbowColorComposition implements Color {

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

                class RainbowColorInheritance extends Rainbow implements Color {

                    @Override
                    public void apply(Video video) {
                        setUp();
                        update(video);
                    }
                }

*/

public class Notes {
    public static void main(String[] args) {

        VideoEditor videoEditor = new VideoEditor(new Video());

        videoEditor.applyColor(new BlackAndWhite());
        System.out.println();

        videoEditor.applyColor(new Midnight());
        System.out.println();

        videoEditor.applyColor(new RainbowColorInheritance());
        System.out.println();

        videoEditor.applyColor(new RainbowColorComposition(new Rainbow()));
    }
}

class Video {

    // video fields and methods
}

interface Color {

    void apply(Video video);
}

class BlackAndWhite implements Color {

    @Override
    public void apply(Video video) {
        System.out.println("Applying black and white to video");
    }
}

class Midnight implements Color {

    @Override
    public void apply(Video video) {
        System.out.println("Applying Midnight-purple to the video");
    }
}

class VideoEditor {

    private Video video;

    public VideoEditor(Video video) {
        this.video = video;
    }

    public void applyColor(Color color) {

        color.apply(video);
    }
}

class Rainbow {

    public void setUp() {
        System.out.println("Setting up rainbow filter");
    }

    public void update(Video video) {
        System.out.println("Applying rainbow filter to video");
    }
}

class RainbowColorComposition implements Color {

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

class RainbowColorInheritance extends Rainbow implements Color {

    @Override
    public void apply(Video video) {
        setUp();
        update(video);
    }
}
