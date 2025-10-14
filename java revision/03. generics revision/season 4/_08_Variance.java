/*

    NOTES:
    - Invariance vs Covariance vs Contravariance
        - Invariance -> No type flexibility; must match exactly.
        - Covariance -> Allows assigning a more specific (subtype) to a more general reference.
        - Contravariance -> Allows assigning a more general (supertype) to a more specific reference.

    - Invariance:
        Generics (strict type match):   // exact type match required
            - List<Dog> dogList = new ArrayList<Dog>(); // YES
            - List<Dog> dogList = new ArrayList<Husky>(); // NO

    - Covariance:
        Java (Polymorphism, not generics):
            - Number numInt = new Integer(10);
            - Number numFloat = new Float(10.4f);

        Generics (`? extends`): // (read-only, subtypes allowed)
            - List<? extends Dog> dogList = new ArrayList<Husky>(); // YES
            - List<? extends Animal> catList = new ArrayList<Cat>(); // YES

    - Contravariance:
        Generics (`? super`):   // (write-only, supertypes allowed)
            - List<? super Dog> dogList = new ArrayList<Animal>(); // YES
            - List<? super Animal> animalList = new ArrayList<Object>(); // YES
            - List<? super Animal> creatureList = new ArrayList<Creature>(); // YES

            - List<? super Animal> animalList = new ArrayList<Dog>(); // NO
            - List<? super Animal> animalList = new ArrayList<IndianCat>(); // NO
            - List<? super Animal> animalList = new ArrayList<Husky>(); // NO

 */

public class _08_Variance {
}