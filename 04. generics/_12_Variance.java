/*
    NOTES:
    Invariance vs Covariance vs Contravariance
        - Invariance -> No type flexibility; must match exactly.
        - Covariance -> Allows assigning a more specific (subtype) to a more general reference.
        - Contravariance -> Allows assigning a more general (supertype) to a more specific reference.

    Invariance:
        Generics (strict type match):
            - List<Dog> dogList = new ArrayList<Dog>(); // YES
            - List<Dog> dogList = new ArrayList<Husky>(); // NO
            - List<Husky> dogList = new ArrayList<Husky>(); // YES

    Covariance:
        Java (Polymorphism, not generics):
            - Number numInt = new Integer(10);
            - Number numDoub = new Double(10.5);
            - Number numFloat = new Float(10.4f);

        Generics (`? extends`):
            - List<? extends Dog> dogList = new ArrayList<Husky>(); // YES
            - List<? extends Animal> animalList = new ArrayList<Dog>(); // YES
            - List<? extends Animal> catList = new ArrayList<Cat>(); // YES

    Contravariance:
        Generics (`? super`):
            - List<? super Dog> dogList = new ArrayList<Animal>(); // YES
            - List<? super Animal> animalList = new ArrayList<Object>(); // YES
            - List<? super Animal> creatureList = new ArrayList<Creature>(); // YES

            - List<? super Animal> animalList = new ArrayList<Dog>(); // NO
            - List<? super Animal> animalList = new ArrayList<IndianCat>(); // NO
            - List<? super Animal> animalList = new ArrayList<Husky>(); // NO



    KEY:
        - In generics, default is invariant — exact type match required
        - Use `extends` for covariance (read-only, subtypes allowed)
        - Use `super` for contravariance (write-only, supertypes allowed)

        - <? super Type> (lower-bounded wildcard):
            - Accepts `Type` or its supertypes.
            - Opposite of covariance, which accepts `Type` or its subtypes.

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