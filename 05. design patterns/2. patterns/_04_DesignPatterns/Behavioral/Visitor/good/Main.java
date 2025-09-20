package _04_DesignPatterns.Behavioral.Visitor.good;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Client> clients = List.of(
                new LawClient("Debianhams", "team@deian.co.uk"),
                new RetailClient("John Lewis", "some@random.com"),
                new RestaurantClient("Pizza Hut", "safe@inpizzahut.co.ke"));

        for (Client client : clients) {
            // client.accpet(new EmailVisitor());
            client.accept(new PDFExportVistor());
        }
    }
}
