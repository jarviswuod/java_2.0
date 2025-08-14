/*

    NOTES:
    - What you are really saying is, the List passed here be either an animalList, creatureList or objectList, those are the 3 possible probabilities of objects we will be accepting in runtime
            - public static void addAnimal(List<? super Animal> animalList) {...}

    - Logically, it means it's safe to add a list of any subclass of Animal inside the method, say Cat or Dog
            - animalList.add(new Cat());
            - animalList.add(new Dog());


    - Reason, we know whatever will be coming to this List being super than what we pass. In this case; Animal, Creature, or Object Lists will be able to hold our subclasses.
    - Example;
            public void addAnimal(List<? super Animal> animalList) {
                animalList.add(new Animal());
                animalList.add(new Cat());
                animalList.add(new Dog());
            }

            public static void addAnimal2(List<? super Cat> animalList) {
                animalList.add(new Cat());
                animalList.add(new IndianCat());
                // animalList.add(new Animal()); -> Type mistmatch
                // animalList.add(new Dog()); -> Type mistmatch
                // animalList.add(new Husky()); -> Type mistmatch
            }

    - This is all the same as;
            List<? super Animal> animalList =  new ArrayList<Animal>();
            List<? super Animal> animalList =  new ArrayList<Creature>();
            List<? super Animal> animalList =  new ArrayList<Object>();

        All the arrayLists will and can contain; Cat(), Dog(), IndianCat() or Husky()

 */

public class _12_Contravariance {
}