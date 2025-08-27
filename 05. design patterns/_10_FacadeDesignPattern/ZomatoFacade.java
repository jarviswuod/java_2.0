package _10_FacadeDesignPattern;

public class ZomatoFacade {
    private Restaurant restaurant;
    private DeliveryTeam deliveryTeam;
    private DeliveryBoy deliveryBoy;

    public void placeOrder() {
        restaurant.prepareOrder();
        deliveryTeam.assignDeliveryBoy();
        deliveryBoy.pickupOrder();
        deliveryBoy.deliveryOrder();
    }
}
