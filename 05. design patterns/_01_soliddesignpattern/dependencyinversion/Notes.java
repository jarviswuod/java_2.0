package _01_soliddesignpattern.dependencyinversion;

/*

    NOTES:
    - Dependency Inversion: This means we should not be having any dependencies on any modules or any submodules. SO high lvel modules should not be having dependecy on low level modules or any classes or objects of it. 
    - We should design it such that it doesnot have dependencies on each other on different classes and objects

    - BAD EXAMPLE EXPLANATION:
    - GOOD EXAMPLE EXPLANATION:

    
    - Code Example:
        - Under the bad design, we have the Calculator, we have calculate method() and itn this calculate method we have a swith statement for passing the operation we want, if we pass the "add" we are creating the AddOperation (using th new keyword) and when we pass the "sub" we are creating the SubOperation too. We have the SubOperation and AddOperation classes
        - With this design, there is a flaw because, your high level module should not have dependency on low level modules, over here a high level module is Calculator {}, the calculate() method, this calculate() method have dependecy on AddOperation and SubOperation class this is because, we are creating new insantances of the classes themselves. i.e you need an isntance of AddOperation to be created to be able to use it yin our method, violating the Dependency Inversion, you have the dependecy that you need or you creating one on your own.
        - We have to change it in a such a way that we dont directly dependant classes or objects that have been created

        - Under the Good design, we created the CalculateOperation interface which has calculate() method which takes 2 numbers. This CalculateOperation has been implemented by the AddOperation and SubOperation. When we now come to the Calculator class, we have no dependency, what we are doing is passing the 2 variables as parameters to calculate() methos and then we are just passing the operation, we are not creaitng any object or anything and whatever expression you pass as  CalculateOperation that will be calulated directly. This is also future proof as we can just safely add Division and Multiplication operations with no worries

 */

public class Notes {

}
