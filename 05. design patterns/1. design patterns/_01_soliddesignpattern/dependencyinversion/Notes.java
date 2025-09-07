package _01_soliddesignpattern.dependencyinversion;

/*

    NOTES:
    - Dependency Inversion: This means we should not be having any dependencies on any modules or any sub-modules; meaning high level modules should not be having dependency on low level modules or any classes or objects of it. 
    - We should design it such that NO dependencies on each other on different classes and objects

    - As per DIP rule which states;
        - High-level modules should not depend on low-level modules. Both should on abstractions
            - This rule is broken as our calculator class is directly dependent on low level class

        - Abstractions should not depend on details. Details should depend on abstractions
            - Broke this rule too as we dependent on the actual class
    
    - BAD EXAMPLE EXPLANATION:
        - Calculator interface, is having calculate method() where we have a swith statement for passing the operation we want, if we pass the "add" we are creating the AddOperation (using the new keyword) and when we pass the "sub" we are creating the SubOperation too
            public class Calculator {
                public int calcualate(int a, int b, String operation) {
                    ...
                    
                    switch (operation) {
                        case "add":
                            AddOperation addOperation = new AddOperation();
                            return addOperation.add(a, b);
                            break;
                    }
                }
            }

        - With this design, there's a flaw coz, your high level modules should not have dependency on low level modules, over here a high level module is Calculator {}, with calculate() method
        - The calculate() method have dependecy on AddOperation and SubOperation class coz, new instances of the classes are needed and created i.e you need an instances of AddOperation to be created to be able to use it in our method. This is violating the Dependency Inversion principle
        - We have to change it in a such a way that we don't directly dependant on classes or objects we do create


    - GOOD EXAMPLE EXPLANATION:
        - Here the CalculateOperation interface has calculate() method which takes 2 numbers
                public class Calculator {
                    public int calcualate(int a, int b, CalcOperation calcOperation) {
                        return calcOperation.calcualate(a, b);
                    }
                }

        - This interface has been implemented by the AddOperation and SubOperation
                public class SubOperation implements CalcOperation {...}
                
                public class AddOperation implements CalcOperation {...}
                
        - When we now come to the Calculator class, we have no dependency, we just pass 2 variables as parameters to calculate() methods and then we are just passing the operation, no object creation and whatever expression needed is passed at CalculateOperation and calculated directly
                public class Calculator {
                    public int calcualate(int a, int b, CalcOperation calcOperation) {
                        return calcOperation.calcualate(a, b);
                    }
                }
        
        - This is also future proof as we can just safely add Division and Multiplication operations with no worries

 */

public class Notes {

}
