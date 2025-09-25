package _04_DesignPatterns.Creational.FactoryMethod.good.MVCFramework;

public class TwigController extends Controller {

    @Override
    protected ViewEngine CreateViewEngine() {
        return new TwigViewEngine();
    }
}
