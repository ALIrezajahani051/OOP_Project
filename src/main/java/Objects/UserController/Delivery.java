package Objects.UserController;

import Objects.DeliveryPanelController;

public class Delivery extends User{

    private DeliveryPanelController Panel = new DeliveryPanelController(this.getId());
}
