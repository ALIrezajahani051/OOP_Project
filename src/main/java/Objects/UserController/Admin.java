package Objects.UserController;


import Objects.AdminPanelController;
import Objects.Restaurant;

import java.util.ArrayList;

public class Admin extends User{


    private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();


    public void addRestaurants(Restaurant restaurants) {
        this.restaurants.add(restaurants);
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}
