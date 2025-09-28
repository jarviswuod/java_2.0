package _02_Singleton;

import java.io.Serializable;

public class _03_MultithreadSingleton implements Serializable {

    private static _03_MultithreadSingleton instance = null;

    private _03_MultithreadSingleton() {

    }

    public static _03_MultithreadSingleton getInstance() {
        if (instance == null) {

            synchronized (_03_MultithreadSingleton.class) {
                if (instance == null) {
                    instance = new _03_MultithreadSingleton();
                }
            }
        }

        return instance;
    }
}
