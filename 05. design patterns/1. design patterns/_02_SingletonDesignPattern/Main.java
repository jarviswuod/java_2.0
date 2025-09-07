package _02_SingletonDesignPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        System.out.println("------------------ SERIALIZATION ------------------");
        exampleSerialization();

        System.out.println("------------------ REFLECTION ------------------");
        exampleReflection();
    }

    private static void exampleSerialization() throws FileNotFoundException, IOException, ClassNotFoundException {

        _01_LazySingleton lazySingleton = _01_LazySingleton.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.obj"));
        objectOutputStream.writeObject(lazySingleton);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.obj"));
        _01_LazySingleton deserializedLazy = (_01_LazySingleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("Object 1 :" + lazySingleton.hashCode());
        System.out.println("Object 2 :" + deserializedLazy.hashCode());

        // SERIALIZATION SOLVED FOR::
        // ------------------------------
        _04_SerializableSingleton serializableSingleton = _04_SerializableSingleton.getInstance();

        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream("object1.obj"));
        objectOutputStream2.writeObject(serializableSingleton);
        objectOutputStream2.close();

        ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream("object1.obj"));
        _04_SerializableSingleton deserializedInstance = (_04_SerializableSingleton) objectInputStream2.readObject();
        objectInputStream2.close();

        System.out.println("serializableSingleton 1 :" + serializableSingleton.hashCode());
        System.out.println("serializableSingleton 2 :" + deserializedInstance.hashCode());
    }

    private static void exampleReflection()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor[] constructors = _01_LazySingleton.class.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);

        _01_LazySingleton lazySingleton = (_01_LazySingleton) constructor.newInstance();
        _01_LazySingleton instance = _01_LazySingleton.getInstance();
        System.out.println("Reflected singleton :" + lazySingleton.hashCode());
        System.out.println("Singleton instance :" + instance.hashCode());

        _05_EnumSingleton.INSTANCE.doSomething();
    }
}