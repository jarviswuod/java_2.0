package _02_Singleton;

import java.io.Serializable;

public class _01_LazySingleton implements Serializable {

    private static _01_LazySingleton instance = null;

    private _01_LazySingleton() {

    }

    public static _01_LazySingleton getInstance() {
        if (instance == null) {
            instance = new _01_LazySingleton();
        }
        return instance;
    }
}
