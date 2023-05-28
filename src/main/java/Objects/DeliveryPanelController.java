package Objects;

import Database.Models.UserModule;
import Objects.UserController.Delivery;

public class DeliveryPanelController {

    private Delivery delivery;

    public DeliveryPanelController(int delivery_id){
        this.delivery = (Delivery) UserModule.getUser(delivery_id);
    }

    public void getorderwithoutdelivery(){

    }

    public void selectorder(){

    }
}
