package _03_Design.Structural.Flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    NOTES:
    - Flyweight design pattern:

    - Is a design pattern that introduces an object to access control of another object allowing for modifications without affecting the original object

    - 3 Key players:
        - Flyweight Factory
        - Flyweight class
        - Object



    - FIRST TRIAL::: ::: :::

            public class Notes {
                public static void main(String[] args) {

                    CropService cropService = new CropService(new CropFactory());

                    for (Crop crop : cropService.getList()) {
                        crop.render();
                    }
                }
            }

            enum CropType {

                Carrot, Wheat, Maize
            }

            class Crop {

                private int x;
                private int y;

                private CropIcon cropIcon;

                public Crop(int x, int y, CropIcon cropIcon) {
                    this.x = x;
                    this.y = y;
                    this.cropIcon = cropIcon;
                }

                public void render() {
                    System.out.println("Rendering solution " + cropIcon + " " + x + " " + y);
                }
            }

            class CropIcon {

                private CropType cropType;
                private byte icon[];

                public CropIcon(CropType cropType, byte[] icon) {
                    this.cropType = cropType;
                    this.icon = icon;
                }

                public CropType getCropType() {
                    return cropType;
                }
            }

            class CropService {

                private CropFactory cropFactory;

                public CropService(CropFactory cropFactory) {
                    this.cropFactory = cropFactory;
                }

                public List<Crop> getList() {
                    List<Crop> list = new ArrayList<>();

                    Crop crop1 = new Crop(9, 2, cropFactory.getCropType(CropType.Carrot));
                    Crop crop2 = new Crop(3, 3, cropFactory.getCropType(CropType.Carrot));
                    Crop crop3 = new Crop(2, 4, cropFactory.getCropType(CropType.Carrot));
                    Crop crop4 = new Crop(3, 6, cropFactory.getCropType(CropType.Carrot));
                    Crop crop5 = new Crop(1, 7, cropFactory.getCropType(CropType.Carrot));

                    list.add(crop1);
                    list.add(crop2);
                    list.add(crop3);
                    list.add(crop4);
                    list.add(crop5);

                    return list;
                }
            }

            class CropFactory {

                private Map<CropType, CropIcon> icons = new HashMap<>();

                public CropIcon getCropType(CropType cropType) {

                    if (!icons.containsKey(cropType)) {
                        CropIcon cropIcon = new CropIcon(cropType, null);
                        icons.put(cropType, cropIcon);
                    }
                    return icons.get(cropType);
                }
            }


 */

public class Notes {
    public static void main(String[] args) {

        CropService cropService = new CropService(new CropFactory());

        for (Crop crop : cropService.getList()) {
            crop.render();
        }
    }
}

enum CropType {

    Carrot, Wheat, Maize
}

class Crop {

    private int x;
    private int y;

    private CropIcon cropIcon;

    public Crop(int x, int y, CropIcon cropIcon) {
        this.x = x;
        this.y = y;
        this.cropIcon = cropIcon;
    }

    public void render() {
        System.out.println("Rendering solution " + cropIcon + " " + x + " " + y);
    }
}

class CropIcon {

    private CropType cropType;
    private byte icon[];

    public CropIcon(CropType cropType, byte[] icon) {
        this.cropType = cropType;
        this.icon = icon;
    }

    public CropType getCropType() {
        return cropType;
    }
}

class CropService {

    private CropFactory cropFactory;

    public CropService(CropFactory cropFactory) {
        this.cropFactory = cropFactory;
    }

    public List<Crop> getList() {
        List<Crop> list = new ArrayList<>();

        Crop crop1 = new Crop(9, 2, cropFactory.getCropType(CropType.Carrot));
        Crop crop2 = new Crop(3, 3, cropFactory.getCropType(CropType.Carrot));
        Crop crop3 = new Crop(2, 4, cropFactory.getCropType(CropType.Carrot));
        Crop crop4 = new Crop(3, 6, cropFactory.getCropType(CropType.Carrot));
        Crop crop5 = new Crop(1, 7, cropFactory.getCropType(CropType.Carrot));

        list.add(crop1);
        list.add(crop2);
        list.add(crop3);
        list.add(crop4);
        list.add(crop5);

        return list;
    }
}

class CropFactory {

    private Map<CropType, CropIcon> icons = new HashMap<>();

    public CropIcon getCropType(CropType cropType) {

        if (!icons.containsKey(cropType)) {
            CropIcon cropIcon = new CropIcon(cropType, null);
            icons.put(cropType, cropIcon);
        }
        return icons.get(cropType);
    }
}
