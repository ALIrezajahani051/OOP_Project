package Objects.InputController;

import Database.Models.RestaueantModule;
import ObjectCreator.RestaurantCreator;
import Objects.AdminPanelController;
import Objects.Food;
import Objects.Restaurant;
import Objects.RestaurantPanel;
import Objects.UserController.Admin;
import Objects.UserController.User;

import java.util.ArrayList;
import java.util.HashMap;

import static Objects.InputController.RestaurantInputController.selectfood;
import static Objects.InputController.RestaurantInputController.showactionlist;

public class AdminInputController {
    public static void getAdminRestaurants() {
    }

    public static void showAdminRestaurants() {
        System.out.println("its ok showAdminRestaurants");

        try {
            ArrayList<HashMap<String, String>> restaurants = AdminPanelController.Panel.showRestaurants();
            System.out.println("id            name            type");
            for (HashMap<String, String> restaurant: restaurants) {
                System.out.println(restaurant.get("id") +".            " + restaurant.get("name") + "            " + restaurant.get("foodtype"));
            }
        }catch (Exception e){
            System.out.println("invalid");
        }
    }

    public static void selectRestaurant() {
        System.out.println("its ok select");


            showAdminRestaurants();
            int id = Integer.parseInt(InputController.getLine());
            AdminPanelController.selectRestaurant(id);
            System.out.println("you are in Panel restaurant " + Restaurant.inrestaurant.getName());
            showactionlist();



    }






}
