package _03_Design.Behavior.Strategy;

import java.util.Objects;

/*

    NOTES:
    - Is a behavioural behavior that defines a collection of related algorithms that can be swapped and used at runtime
    - Key players:
        - Context
        - Strategy interface
        - Concrete Strategy

    - Example:
        - VideoEditor

*/

public class _01_Strategy {
    public static void main(String[] args) {

        _VideoEditor videoEditor = new _VideoEditor(new _CompMP4(), new _BlackAndWhite());
        videoEditor.store("path/to/video/file");
        System.out.println();

        videoEditor.setColor(new _Greyscale());
        videoEditor.setCompression(new _ZipForm());
        videoEditor.store("file/path/");

    }
}

class Video {

}

interface _Compression {

    void compress();
}

interface _Color {

    void change();
}

class _VideoEditor {

    private _Compression compression;
    private _Color color;

    public _VideoEditor(_Compression compression, _Color color) {
        this.compression = Objects.requireNonNull(compression, "Compression cannot be null");
        this.color = Objects.requireNonNull(color, "Color filter cannot be null");
    }

    public void store(String filePath) {
        compression.compress();
        color.change();
        System.out.println("Video setting of " + filePath + " succesfully changed");
    }

    public _Compression getCompression() {
        return compression;
    }

    public void setCompression(_Compression compression) {
        this.compression = compression;
    }

    public _Color getColor() {
        return color;
    }

    public void setColor(_Color color) {
        this.color = color;
    }
}

class _Blur implements _Color {

    @Override
    public void change() {
        System.out.println("Applying blur to video");
    }
}

class _Greyscale implements _Color {

    @Override
    public void change() {
        System.out.println("Applying grey scale to video");
    }
}

class _BlackAndWhite implements _Color {

    @Override
    public void change() {
        System.out.println("Applying black and white to video");
    }
}

class _CompMP4 implements _Compression {

    @Override
    public void compress() {
        System.out.println("Compressing video to mp4");
    }
}

class _ZipForm implements _Compression {

    @Override
    public void compress() {
        System.out.println("Compressing video to ZipForm");
    }
}

class _Unknown implements _Compression {

    @Override
    public void compress() {
        System.out.println("Compressing video to Unknown");
    }
}