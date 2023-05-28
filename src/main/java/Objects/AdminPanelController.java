package Objects;

import Database.Models.RestaueantModule;
import Database.Models.UserModule;
import ObjectCreator.RestaurantCreator;
import Objects.UserController.User;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminPanelController {

    public static AdminPanelController Panel;

    private User user;
    public AdminPanelController(User logger) {
        this.user = logger;
    }


    public  ArrayList<Restaurant> getRestaurant(){
        return new ArrayList<>();
    }

    public void addnewresp(){

    }

    public void editresp(){

    }


    public static void selectRestaurant(int id){
        Restaurant restaurant = RestaurantCreator.CreateRestaurantObject(id);
        Restaurant.inrestaurant = restaurant;
        RestaurantPanel.Panel = new RestaurantPanel(restaurant);
    }
    public ArrayList<HashMap<String, String>> showRestaurants(){
        return RestaueantModule.getRestaurantsAdmin();
    }















}
