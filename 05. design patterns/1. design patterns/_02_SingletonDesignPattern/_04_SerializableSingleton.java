package _02_SingletonDesignPattern;

import java.io.Serializable;

public class _04_SerializableSingleton implements Serializable {

    private static _04_SerializableSingleton instance = null;

    private _04_SerializableSingleton() {

    }

    public static _04_SerializableSingleton getInstance() {
        if (instance == null) {
            instance = new _04_SerializableSingleton();
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }

}
