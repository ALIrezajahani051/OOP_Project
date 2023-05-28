package Objects;

import Database.Models.OrderModule;
import Database.Models.UserModule;
import Objects.UserController.User;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderController {


    User buyer;

    public OrderController(User user){
        buyer = user;
    }

    public void addToCart(int food_id){
        OrderModule.addToCartDB(food_id);
        //id = TODO
        Order order = new Order();
        order.setId(0);
        order.setPk_order(UserModule.getLastPK());
        order.setFood_id(food_id);
        order.setUser_id(buyer.getid());

        buyer.addToCart(order);
    }



    public ArrayList<Order> getcart(){
        return OrderModule.getUserCart();
    }

    public OrderEnum confirmCart(){
        // change status pk and generic a new pk
        int toprc = OrderModule.getTotalPrice();
        if(buyer.getCredit() < toprc)
            return OrderEnum.CREDIT_DOES_NOT_ENUGH;
        OrderModule.UpdateTOConfirm();
        buyer.clearCart();
        buyer.setCredit(buyer.getCredit() - toprc);
        return  OrderEnum.DONE;
    }



    public HashMap<String,ArrayList<Order>> historyOrder(){
        return OrderModule.getHistory();
    }

    public void getorder(){

    }



    public static void getEstimatedDeliveryTime(int order_id){

    }

    //check mony is counfg




}
