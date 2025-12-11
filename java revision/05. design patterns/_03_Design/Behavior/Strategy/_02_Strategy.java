package _03_Design.Behavior.Strategy;

/*

    NOTES:
    - Is a behavioral pattern that defines a group of relates algorithms that can be swapped and used dynamically at runtime
    - Key players:
        - Context
        - Strategy
        - Context Strategy

    - Example:
        - VideoEditing; Compress and Overlay

*/

public class _02_Strategy {
    public static void main(String[] args) {

        _02_Video video = new _02_Video();

        _02_VideoEditor videoEditor = new _02_VideoEditor(new _02_FFD(), new _02_BlackAndWhite_());
        videoEditor.save(video);
        System.out.println();

        videoEditor.setCompress(new _02_Mp4());
        videoEditor.save(video);

    }
}

class _02_Video {
}

interface _02_Overlay {

    void apply();
}

interface _02_Compress {

    void compress();
}

class _02_Mp4 implements _02_Compress {

    @Override
    public void compress() {
        System.out.println("_02_Mp4 implements applied to video");
    }
}

class _02_Mov implements _02_Compress {

    @Override
    public void compress() {
        System.out.println("_02_Mov implements applied to video");
    }
}

class _02_FFD implements _02_Compress {

    @Override
    public void compress() {
        System.out.println("_02_FFD implements applied to video");
    }
}

class _02_BlackAndWhite_ implements _02_Overlay {

    @Override
    public void apply() {
        System.out.println("_02_BlackAndWhite_ implements applied to video");
    }
}

class _02_Blue implements _02_Overlay {

    @Override
    public void apply() {
        System.out.println("_02_Blue implements applied to video");
    }
}

class _02_Santos implements _02_Overlay {

    @Override
    public void apply() {
        System.out.println("_02_Santos implements applied to video");
    }
}

class _02_VideoEditor {

    private _02_Compress compress;
    private _02_Overlay overlay;

    public _02_VideoEditor(_02_Compress compress, _02_Overlay overlay) {
        this.compress = compress;
        this.overlay = overlay;
    }

    public _02_Compress getCompress() {
        return compress;
    }

    public void setCompress(_02_Compress compress) {
        this.compress = compress;
    }

    public _02_Overlay getOverlay() {
        return overlay;
    }

    public void setOverlay(_02_Overlay overlay) {
        this.overlay = overlay;
    }

    public void save(_02_Video video) {
        overlay.apply();
        compress.compress();

        System.out.println("Video saved successfully " + overlay.getClass().getName() + " compress "
                + compress.getClass().getName());
    }
}
