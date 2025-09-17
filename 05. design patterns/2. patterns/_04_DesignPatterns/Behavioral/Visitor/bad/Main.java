package _04_DesignPatterns.Behavioral.Visitor.bad;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Client> clients = List.of(
                new LawClient("Debianhams", "team@deian.co.uk"),
                new RetailClient("John Lewis", "some@random.com"),
                new RestaurantClient("Pizza Hut", "safe@inpizza.com"));

        for (Client client : clients) {
            client.sendEmail();
        }
    }
}
