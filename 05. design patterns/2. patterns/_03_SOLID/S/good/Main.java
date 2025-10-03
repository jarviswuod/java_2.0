package _03_SOLID.S.good;

public class Main {
    public static void main(String[] args) {

        User user = new User("jarviswuod", "jarvis@wuod.com");
        UserService userService = new UserService();
        userService.register(user);

        System.out.println();
        userService.register(new User("justjarvis", "jarvis@just.com"));
    }
}
