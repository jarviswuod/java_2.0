/*

    OFFHEAD NOTES:
    
    COMMON CASE:
        - Non-static inner class instantiated through outer class instance
            - A.C obj2 = obj.new C(); 
            - obj2.config();
        - One-liner instantiation of non-static inner class
            - A.C obj3 = new A().new C(); 
            - obj3.config();
        - Static inner class instantiated without outer class
            - A.B obj1 = new A.B(); 
            - obj1.config();
        - Call static methods directly
            - A.B.showStaticInner(); 


    CASE 1: Non-Static Inner Classes
        - Create inner class directly
            - OuterClass.InnerClass inner = outer.new InnerClass();
            - inner.displayBoth();
        - One-liner creation
            - OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();
            - inner2.innerMethod();


    CASE 2: Non-static outerClass
    Static Inner Classes (Static Nested Classes)
        - No need to create outer class instance
            - new OuterClassStatic.StaticInnerClass();
        - Can call static methods directly
            - OuterClassStatic.staticOuterMethod();
            - OuterClassStatic.StaticInnerClass.staticInnerMethod();


    CASE 3: Method Local Inner Classes
    public static void main(String[] args) {
        _34_3_InnerClasses example = new _34_3_InnerClasses();
        example.outerMethod();
    }


    CASE 4: Anonymous Inner Classes
        - Anonymous class implementing interface
        - Anonymous class extending abstract class


 */

public class _35_InnerClasses {

    public static void main(String[] args) {

    }
}
