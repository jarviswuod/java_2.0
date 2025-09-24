package _04_DesignPatterns.Structural.Flyweight;

/*

    CODE EXPLANATION:

    - CHALLENGE:
        - Say that we have a farming game that includes different types of crops, such as potatoes, carrots and wheat. Each crop is represented by a Crop object, that includes it's X ad Y coordinates, the type of crop, and an icon;
        - We want a solution is that for every carrot created, we are storing a new object with all of the information about a carrot stored within that object. This means that if we create 1000 carrots, then we will be storing 1000 carrot icons in RAM - that's going to take up lots of memory, and many mobile devices will struggle to handle that


    - SOLUTTION 1:
        - CropType enum:
            - It can take a crop type of either potato, carrot or wheat
                    public enum CropType {

                        Potato, Carrot, Wheat;
                    }


        -  Crop class:
            - We have a position coordinates (x and y) then we also have a cropType and we also have an icon that we can represent as an array of bytes
            - We then create a constructor of the Crop passing all the fields
            - We then need a render() method for rendering crop to the screen; for simplisity we just log to the console some dummy text

                    public class Crop {

                        private int x; // 4 bytes
                        private int y; // 4 bytes
                        private CropType cropType; // 40 bytes * 1000 crops --> 40mb
                        private byte[] icon; // 4 bytes

                        public Crop(int x, int y, CropType cropType, byte[] icon) {
                            this.x = x;
                            this.y = y;
                            this.cropType = cropType;
                            this.icon = icon;
                        }

                        public void render() {
                            System.out.println("Crop [x=" + x + ", y=" + y + ", cropType=" + cropType + "]");
                        }
                    }


        - CropService class;
            - This class is essentially used to fetch our crops and it will probably be stored in some database
            - We have a method called getCrops() which returns list of Crops;
            inside the method we first create a cropList and then we simulate fecthing our crops from a db, since we have no db connected we will just manually create some Crops objects. We then add the crops we created to the crop list and then finally we return the cropList we added crops to

            - NOTE: This CropService with it's getCrops() method is just simulating what we would do in real application which is probably fetch the crops from the db and then return the list of crops and each Crop know it's position to be rendered(x, y), each type of crop and an icon for that crop type

                    public class CropService {

                        public List<Crop> getCrops() {
                            List<Crop> cropList = new ArrayList<>();

                            // fetch from db
                            Crop carrot1 = new Crop(1, 4, CropType.Carrot, null);
                            Crop carrot2 = new Crop(1, 5, CropType.Carrot, null);
                            Crop carrot3 = new Crop(1, 6, CropType.Carrot, null);
                            Crop carrot4 = new Crop(1, 9, CropType.Carrot, null);

                            cropList.add(carrot1);
                            cropList.add(carrot2);
                            cropList.add(carrot3);
                            cropList.add(carrot4);

                            return cropList;
                        }
                    }


        - Main class: Client class;
            - First we create a CropService object and then we can loop through our crops and render them on the screen
                    public class Main {
                        public static void main(String[] args) {

                            CropService cropService = new CropService();

                            for (Crop crop : cropService.getCrops()) {
                                crop.render();
                            }
                        }
                    }



    - SOLUTION 2: Flyweight Pattern:
        - We will be refactoring our bad solution code

        - CropType enum:
            - Nothing changes here

        - Crop class:
            - Here we nolonger need the CropType and icon fields instead we will make reference to cropIcon object
            - Same concept applies inside our constructor, swap icons and CropType with CropIcon
            - We will modify the render() method too under cropIcon.getType()

                    public class Crop {

                        private int x;
                        private int y;
                        private CropIcon cropIcon;

                        public Crop(int x, int y, CropIcon cropIcon) {
                            this.x = x;
                            this.y = y;
                            this.cropIcon = cropIcon;
                        }

                        public void render() {
                            System.out.println("Crop [x=" + x + ", y=" + y + ", cropType=" + cropIcon.getType() + "]");
                        }
                    }


        - CropIcon class:
            - This is our flyweight class that stores intrinsic  or constant state, the state that remains constant througout the object's life. Whereas our Crop class will store our extrinsic state which will change throughout our object's life
            - Here we will store 2 fields, CropType and icon which is an array of bytes. we can make the fields readonly such that once the object is contructed they cannot be changed
            - Then we create our constructor
            - Finally we create our getter for cropType which we can use outside the class and inside the Crop class

                    public class CropIcon {

                        private CropType type;
                        private byte[] icon;

                        public CropIcon(CropType type, byte[] icon) {
                            this.type = type;
                            this.icon = icon;
                        }

                        public CropType getType() {
                            return type;
                        }
                    }


        - CropIconFactory class:
            - This class ensures that each unique crop icon object is created only once, cached and then reused or shared between the crop Objects
            - First we create our Map called icon which stores CropType as key and CropIcon as value to the key
            - Then we create our getCropIcon()method which takes a cropType that we want to get an icon for,, if we want to get the icon for a carrot we pass crop type as carrot into the getCropIcon() method
                - Inside here what we need to do is to check it the icon already exists inside of the Maplist 'icons' field(Our cache). We then create our CropIcon object passing the cropType we passed and crop icon which we are currently having as null for convenience
                - We then add the icon to a Map list 'icons'
                - Finally we return the CropIcon filtering the one we want

            - We now have our cropIconFactory which is ensuring that each crop icon object is created once per object crop type

                    public class CropIconFactory {

                        // cache
                        private Map<CropType, CropIcon> icons = new HashMap<>();

                        public CropIcon getCropIcon(CropType cropType) {
                            if (!icons.containsKey(cropType)) {

                                CropIcon icon = new CropIcon(cropType, null);
                                icons.put(cropType, icon);
                            }

                            return icons.get(cropType);
                        }
                    }


        - CropService class;
            - We will be doing some refactoring inside the class, so crop service needs to store a reference to the CropIconFactory, so we can create Field called CropIconFactory and we pass it via the constructor
            - Inside our getCrops() method, we will still need to store a list of crops and then we simulate fetching the crops from the db - this is where we need to make modifications as we nolonger pass in some fields when creating a Crop object. We will use our cropIconFactory to create our crop icon object
                - OLD::
                Crop carrot1 = new Crop(1, 3, CropType.Carrot, null);

                - NEW::
                Crop carrot1 = new Crop(1, 3, cropIconFactory.getCropIcon(CropType.Carrot));

            - All the carrot objects now will be sharing the same crop object which is stored in cache due to our cropIconFactory object. We will still add crop to our cropList and return them

                    public class CropService {

                        private CropIconFactory cropIconFactory;

                        public CropService(CropIconFactory cropIconFactory) {
                            this.cropIconFactory = cropIconFactory;
                        }

                        public List<Crop> getCrops() {
                            List<Crop> cropList = new ArrayList<>();

                            // fetch from db
                            Crop carrot1 = new Crop(1, 4, cropIconFactory.getCropIcon(CropType.Carrot));
                            Crop carrot2 = new Crop(1, 5, cropIconFactory.getCropIcon(CropType.Carrot));
                            Crop carrot3 = new Crop(2, 6, cropIconFactory.getCropIcon(CropType.Carrot));
                            Crop carrot4 = new Crop(2, 8, cropIconFactory.getCropIcon(CropType.Carrot));

                            cropList.add(carrot1);
                            cropList.add(carrot2);
                            cropList.add(carrot3);
                            cropList.add(carrot4);

                            return cropList;
                        }
                    }


        -  Main class: Client Class;
            - We create CropService object passing in cropIconFactory()
            - We still loop into our crops ad we're calling for render
            - NOTE: No much changed the way our Main class uses our solution

                    public class Main {
                        public static void main(String[] args) {

                            CropService cropService = new CropService(new CropIconFactory());

                            for (Crop crop : cropService.getCrops()) {
                                crop.render();
                            }
                        }
                    }


        - OBSERVATION:
            - In summary, we have created 3 carrot crop objects bu tonly one carrot crop icon object, so this solution will save lots of ram when rendering many crops at one time

 */

public class Explanation {

}