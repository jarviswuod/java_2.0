/*

    NOTES:
    - Comparable VS Comparator interface
        - Comparable interface is used to define the natural ordering of objects
        - Comparator interface is used to define custom ordering of objects
        - PriorityQueue uses either Comparable or Comparator to determine the order of elements


        @Override
        public int compareTo(StudentsMarks arg0) {

            current obj < other obj return -1;
            current obj > other obj return 1;
            current obj == other obj return 0;


            if (this.maths < arg0.maths)
                return -1;
            if (this.maths > arg0.maths)
                return 1;
            if (this.maths == arg0.maths)
                return 0;

            return this.maths - arg0.maths;
        }

    
    - When we try to add student objects into the PriorityQueue and we attempt to return the top3 student, we get an error due to fall into an exception. And the Exception is because the PriorityQueue does not know how to compare the StudentsMarks objects.
    - This was working out of the box for Integer because Integer implements Comparable interface and PriorityQueue uses that to compare the elements.

    - To solve this issue around PriorityQueue sorting in CustomClass, we are introduced to both Comparable and
Comparator interfaces concepts

    - We want to get the top students according to their math marks. We can use the Comparable interface which is done at the class level. StudentMarks must have a comparison strategy of it's own for the PriorityQueue to sort it out.
    -  Whenever youa re creating a custom class and you want the custom class be the type of PriorityQueue. You should implement the Comparable class.
    - The Comparable interface forces you to add the compareTo() method.
    - The compareTo() method has a object that it passed, so we basically want to compare this specific object instance with the object that is being passed into this method.
    - We have 3 instances/ situations;
        - current obj < other obj return -1;
        - current obj > other obj return 1;
        - current obj == other obj return 0;
    
    - public int compareTo(StudentsMarks arg0) {
        return this.maths - arg0.maths;
      }
    - At this point when we try to sort the StudentsMarks with help of the a PriorityQueue we face no issue since the PriorityQueue sees the Comparable inteface implmented and comparedTo method already too to sorting based on a logic we want, currently sorting in descending order.
    - Remember when we did sorting using the Integer wrapper class using the PriorityQueue. It was all possible because the Integer wrapper class implments Comparable interface and has the compareTo() set too.
    - The issue in the Integer class arrises, the way the comparedto() works is in ascending order. And thats why we could only get the bottom 2 elements first, instead of the first 2 elements. In order to get the top2 elements you need to change the compareTo method of the Integer class which we are not allowed to access the class coz it's a java package and we cant make change to that. It's not also a good way to handle the situation, we are the clients using the class , we cannot run and change the internals of the class.
    - Comparator Interface comes into place when we want to chage sorting mechanism in the Interger class or our custom class too.
    - We need to implement the Comparator interface in a separate class and we have to ovveride the compare() which takes 2 parameter objects
    - The difference between the compareTo() in Comparable interface and compare() in Comparator interface. SInce the compareTo() method is within the class we want it in, you already have the 'this' object, so you only need one more object to compare it against, when we are using the Comparator interface, it's implemented on the Comparator class and the compare() has nothing to compare it's self to, hence we need 2 parameters to compare against one another

        class MyCustomComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg1 - arg0;
            }
        }

    - When you are creating a PriorityQueue it takes in a constructor which is a Comparator, hence you can just instanciate it as;
        PriorityQueue<Integer> priority = new PriorityQueue<>(new MyCustomComparator());
    - What happens here now is that instead of ordering that our Integer class was following, it will not follow our custom ordering we defined in our Comparator constructor
    - Alternatively we can use lamda expression with help or anynoumous classes, a concept in java;
        PriorityQueue<Integer> priority2 = new PriorityQueue<>((a, b) -> b - a);
    - Total ordering and Natural ordering
        - Whatever ordering the class is implmeneting is called Natural ordering (comparable interface)
        - Whatever ordering we pass into our PriorityQueue as a comparator is called  total ordering
        - Total ordering always has precedence over the Natural ordering
    


 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _12_PriorityQueueInCustomClass {

    public static void main(String[] args) {

        // Get me the top students according to their maths marks

        List<StudentsMarks> marks = new ArrayList<>();
        marks.add(new StudentsMarks(70, 80));
        marks.add(new StudentsMarks(38, 10));
        marks.add(new StudentsMarks(100, 38));
        marks.add(new StudentsMarks(40, 88));
        marks.add(new StudentsMarks(97, 19));

        PriorityQueue<StudentsMarks> priority = new PriorityQueue<>(marks);

        List<StudentsMarks> top3 = new ArrayList<>();
        int index = 0;

        while (!priority.isEmpty()) {
            if (index == 3)
                break;
            top3.add(priority.poll());
            index++;
        }

        System.out.println(top3);
        System.out.println(priority);
    }
}

class StudentsMarks implements Comparable<StudentsMarks> {
    private int maths;
    private int physics;

    public StudentsMarks(int maths, int physics) {
        this.maths = maths;
        this.physics = physics;
    }

    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }

    @Override
    public String toString() {
        return "StudentsMarks [maths=" + maths + ", physics=" + physics + "]";
    }

    @Override
    public int compareTo(StudentsMarks arg0) {
        return this.maths - arg0.maths;
    }
}