package _16_MediatorDesignPattern;

public interface ChatMediator {
    public void sendMessage(String msg, User user);

    void addUser(User user);
}
