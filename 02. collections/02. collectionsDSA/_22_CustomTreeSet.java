import java.util.Set;
import java.util.TreeSet;

public class _22_CustomTreeSet {
    public static void main(String[] args) {

        // Set<StudentsMarks> treeset = new TreeSet<>(); // By default it sorts based on
        // math marks

        Set<StudentsMarks> treeset = new TreeSet<>((s1, s2) -> s2.getPhysics() - s1.getPhysics());
        treeset.add(new StudentsMarks(70, 80));
        treeset.add(new StudentsMarks(38, 10));
        treeset.add(new StudentsMarks(100, 38));
        treeset.add(new StudentsMarks(40, 88));
        treeset.add(new StudentsMarks(97, 19));

        for (StudentsMarks student : treeset) {
            System.out.println(student);
        }
    }
}

class StudentsMarks {
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
}