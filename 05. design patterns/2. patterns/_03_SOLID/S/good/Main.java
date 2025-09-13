package _03_SOLID.S.good;

public class Main {
    public static void main(String[] args) {

        User user = new User("jarviswuod", "jarviswuod@gmail.com");
        UserService userService = new UserService();
        userService.register(user);

        System.out.println();
        userService.register(new User("justjarvis", "justjarvis@gmail.com"));
    }
}
