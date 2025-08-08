/*
 Invariance vs Covariance vs Contravariance
  

 Invariance -> Means it cannot be changed
 Covariance -> Passing a more specific type to a more general one
 Contravariance -> Contra means opposite/ against


 Invariance:
    Java:
        Number numInt = new Integer(10);
        Number numDoub = new Double(10.5);
        Number numFloat = new Float(10.4f);

    Generics:
        List<Dog> dogList =  new ArrayList<Husky>(); // NOPE
        List<Dog> dogList =  new ArrayList<Dog>(); // YES
        List<Husky> dogList =  new ArrayList<Husky>(); // YES

 Covariance:
    Generics:
        List<? extends Dog> dogList =  new ArrayList<Husky>();
        List<? extends Animal> animalList =  new ArrayList<Dog>();
        List<? extends Animal> dogList =  new ArrayList<Cat>();

 Contravariance:
    Generics:
        List<? super Dog> dogList =  new ArrayList<Animal>(); // YES
        List<? super Animal> animalList =  new ArrayList<Object>(); // YES
        List<? super Animal> dogList =  new ArrayList<Creature>(); // YES
        List<? super Animal> animalList =  new ArrayList<Dog>(); // NOPE
        List<? super Animal> animalList =  new ArrayList<IndianCat>(); // NOPE
        List<? super Animal> animalList =  new ArrayList<Husky>(); // NOPE


 NOTE::
 In generics, by default you cannot achieve invariance, everything is strict to what you need to assign it to. We get around this issue by adding the 'extends' keyword to make it invaraint

 (? super Type) Lower bound wild card:
 Nothing is allowed other than the specific class or something above the class. This is as opposed to covariance.

 Providing a more general type

 */

public class _12_Variance {

    public static void main(String[] args) {

    }
}

class Creature {
}

class Animal extends Creature {
}

class Cat extends Animal {
}

class Dog extends Animal {
}

class Husky extends Dog {
}

class IndianCat extends Cat {
}