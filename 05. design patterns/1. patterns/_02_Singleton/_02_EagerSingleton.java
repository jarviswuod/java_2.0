package _02_SingletonDesignPattern;

public class _02_EagerSingleton {
    private static final _02_EagerSingleton instance = new _02_EagerSingleton();

    private _02_EagerSingleton() {
        // Do your init work here
    }

    public static _02_EagerSingleton getInstance() {
        return instance;
    }
}
