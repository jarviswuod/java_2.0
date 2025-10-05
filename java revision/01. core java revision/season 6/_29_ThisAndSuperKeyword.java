/*

    NOTES;
    - This
        - Primary usecase - solve for field and methods naming confusion
        - Fluent interface (Method Chaining)
        - Passing current object as parameter
        - Inner class method to refer to the outer class
            - OuterClass.this.fieldName;

        - Lamda expression
            - listNames.forEach(name::this.methodname);

        - Constructor chaining
            -  this(name, anotherName, thirdName);

        - Synchronize in multithreading


    - Super
        - Primary usecase -> access parent fields and methods
            - super.fieldName;
            - super.methodName();

        - Constructor chaining;
            - super(firstParam, secondParam, thirdParam);

        - Overriding parent field and methods
        - Resolving same name method or field of an multiple interface
            - InterfaceName.super.methodName()
            - Interface2Name.super.methodName()

 */

public class _29_ThisAndSuperKeyword {

}
