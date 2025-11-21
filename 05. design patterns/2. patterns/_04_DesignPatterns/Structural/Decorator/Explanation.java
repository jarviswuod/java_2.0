package _04_DesignPatterns.Structural.Decorator;

/*

    CODE EXPLANATION:


    - CHALLENGE:
        - Say that we have an application that allows users to store data in the cloud. The data can be sent to the cloud as it is without any processing and it can also be compressed and or encrypted before it's saved to the cloud
        - If we need to create a new Validation class to validate and clean the data before it is sent to the cloud. Our code starts to look bloated as we need to make lots of new classes just to add an extra feature



    - SOLUTION 1:
        - CloudData class:
            - This class needs to have a URL field, we are making this a protected field so that the classes that inherit CloudData have access to the URL field
            - Next is creating a constructor passing the URL field because in this location we'll storing the data in the cloud
            - Finally we create a save() method passing in 'data' string and we just log "Saving data to cloud at the URL we passed" for simplicity

                    public class CloudData {

                        protected String url;

                        public CloudData(String url) {
                            this.url = url;
                        }

                        public void save(String data) {
                            System.out.println("Saving data " + data + " to cloud to " + url);
                        }
                    }



        - CompressedData class:
            -  It extends CloudData class as we adding extra functionality and then create a constuctor for CompressedData passing the URL field
            - Then we override the save() method passing in a string 'data';
                - Over here we first compress the data
                - We then call save() method
            - NOTE: compress() method compresses the file we passed. Currently we're just trimming down our string

                    public class CompressedData extends CloudData {

                        public CompressedData(String url) {
                            super(url);
                        }

                        @Override
                        public void save(String data) {
                            String compressed = Compress(data);
                            super.save(compressed);
                        }

                        public String Compress(String data) {
                            return data.substring(0, 9);
                        }
                    }



        - EncryptionData class:
            - Same concept applied to the CompressData class applies here too

                    public class EncryptedData extends CloudData {

                        public EncryptedData(String url) {
                            super(url);
                        }

                        @Override
                        public void save(String data) {
                            String encrypted = Encrypt(data);
                            super.save(encrypted);
                        }

                        public String Encrypt(String data) {
                            return "*$%#@!yuuioo)98876tyyu";
                        }
                    }



        - CompressedAndEncryptedData class:
            - Same concept apllied on CompressedData and EncryptedData applies here too with a slight different on save() method override. We'll first Compress, Encrypt it then save the data

                    public class CompressedAndEncrypted extends CloudData {

                        public CompressedAndEncrypted(String url) {
                            super(url);
                        }

                        @Override
                        public void save(String data) {
                            String compressed = new CompressedData(url).Compress(data);
                            String compressedAndEncrypted = new EncryptedData(url).Encrypt(compressed);
                            super.save(compressedAndEncrypted);
                        }

                        public String CompressedAndEncrypt(String data) {
                            return data.substring(0, 9);
                        }
                    }



        - Main class: Client class;
            - We have a couple of fields; url, data, compress and encrypt
            - We select the correct cloud storage object but first, we create a CloudData object passing the URL then add some conditional checks for if we should compress, encrypt data or do both

            - Finally we call the save() method on cloudData object

                    public class Main {
                        public static void main(String[] args) {

                            String url = "https://google.cloud.com";
                            String data = "This is some data. Hello world. Facade :)";
                            boolean compress = true;
                            boolean encrypt = true;

                            CloudData cloudData = new CloudData(url);

                            if (encrypt && compress) {
                                cloudData = new CompressedAndEncrypted(url);
                            } else if (compress) {
                                cloudData = new CompressedData(url);
                            } else if (encrypt) {
                                cloudData = new EncryptedData(url);
                            }

                            cloudData.save(data);
                        }
                    }


        - PROBLEM:
            - This is all working correctly the issue is that our total number of classes will increase exponentially with this solution.
            - Another thing is we have to perform a lot of conditional checks in the client whenever we use the solution



    - SOLUTION 2: DECORATOR PATTERN;
        - Data interface: Compoenent interface
            - It has a single method for saving the data

                    public interface Data {

                        void save(String data);
                    }



        - CloudData class: Concrete Component
            - It implements the Data interface
            - This is going to be the class that we are going to wrap or add functionality to in other words decorate
            - We have a URL field for storing the data we passed via the constructor then we have a save() method for actually saving the data

                    public class CloudData implements Data {

                        protected String url;

                        public CloudData(String url) {
                            this.url = url;
                        }

                        @Override
                        public void save(String data) {
                            System.out.println("Saving data " + data + " to cloud to " + url);
                        }
                    }



        - DataDecorator class: Decorator interface:
            - This also implements the data interface
            - It needs to store reference to some sort of data object as it will wrap that object or decorate it adding functionality
                - We introude a protected Data data field. The reason it's protected is because the encryption decorator and compression decorator needs half access to the 'data' field
            - Next we create a constructor so that we can pass a data object to wrap
            - Finally we have our save() method which we don't want implemented inside the DataDecorator class itself hence we make it abstract so that it can be overriden or implemented in the compression and encryption subclasses

                    public abstract class DataDecorator implements Data {

                        protected Data data;

                        public DataDecorator(Data data) {
                            this.data = data;
                        }

                        public abstract void save(String data);
                    }



        - ConcreteDecorator class:
            - CompressionDecorator class:
                - We implement the DataDecorator abstract class
                - We then need to implement the constuctor wrapping the data object inside it to the super DataDecorator class
                - We are also overriding the save() method as we'll add our compression logic of which it will be the same as beforehand in our CompressedData Class(Inside the 'bad' package)
                - Since we are not using composition it changes how we call the save() method under save implementation inside the CompressionDecorator class
                    - BEFORE:
                        super.base(compressed);

                    - AFTER:
                        super.data.save(compressed);


                        public class CompressionDecorator extends DataDecorator {

                            public CompressionDecorator(Data data) {
                                super(data);
                            }

                            @Override
                            public void save(String data) {
                                System.out.println("Compressing data");
                                String compressed = Compress(data);
                                super.data.save(compressed);
                            }

                            public String Compress(String data) {
                                return data.substring(0, 9);
                            }
                        }



            - EncryptionDecorator class:
                - It also implements the DataDecorator abstract class
                - Everything else is done as CompressionDecorator class

                - NOTE: DataDecorator class is a class that makes it easy to create the different decorators. It basically kinda is a helper class where we have some basic setup for a decorator which is essentially just passing some sort of wrappy object into the class saving us from having to write the logic inside of both of subclasses

                        public class EncryptionDecorator extends DataDecorator {

                            public EncryptionDecorator(Data data) {
                                super(data);
                            }

                            @Override
                            public void save(String data) {

                                System.out.println("Encrypting data");
                                String encrypted = Encrypt(data);
                                super.data.save(encrypted);
                            }

                            public String Encrypt(String data) {
                                return "*$%#@!yuuioo)98876tyyu";
                            }
                        }



        - Main class: Client class;
            - First we create CloudData object and here we will be passing the URL that we are saving to
            - Next we add our coditional statements
                - If a user wants to encypt the data before saving then we can reset the cloudData to a new EncyptionDecorator passing cloudData to it basically wrapping or decorating the cloud data with an EncryptionDecorator
                - Basically, adding some additional functionality by wrapping this object inside of a decorator rather than creating a new specific subclass. We are wrapping using composition instead of using inheritance and creating a new EncryptionData class like we were before
            
            - Finally we call the save() method on the cloudData object

                    public class Main {
                        public static void main(String[] args) {

                            String url = "https://google.cloud.com";
                            String data = "This is some data. Hello world. Facade :)";
                            boolean compress = false;
                            boolean encrypt = false;

                            Data cloudData = new CloudData(url);

                            if (compress) {
                                cloudData = new CompressionDecorator(cloudData);
                            }
                            if (encrypt) {
                                cloudData = new EncryptionDecorator(cloudData);
                            }

                            cloudData.save(data);
                        }
                    }



        - OBSERVATION:
            - The application works pretty good, and if we try to change the 'compress' and or 'encrypt' fields it works pretty good too

 */

public class Explanation {

}