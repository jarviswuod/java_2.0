package _04_DesignPatterns.Behavioral.Visitor.good;

public class LawClient extends Client {

    public LawClient(String name, String email) {
        super(name, email);
    }

    @Override
    public void accpet(Visitor visitor) {
        visitor.visitLaw(this);
    }
}
