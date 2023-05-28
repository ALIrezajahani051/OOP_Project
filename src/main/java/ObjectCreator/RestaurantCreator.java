package ObjectCreator;

import Database.Models.RateModule;
import Database.Models.RestaueantModule;
import Objects.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantCreator {

    public static  Restaurant CreateRestaurantObject(int id){

        ArrayList<String> data = RestaueantModule.getrestaurantbyid(id);

        Restaurant restaurant = new Restaurant();
        restaurant.setId(Integer.parseInt(data.get(0)));
        restaurant.setName(data.get(1));
        restaurant.setFoodType(data.get(2));
        restaurant.setAddress(data.get(3));
        boolean status = false;
        if (data.get(4).equals("true"))
            status = true;
        restaurant.setStatus(status);
        restaurant.setAdmin(Integer.parseInt(data.get(5)));

        restaurant.setFoods(FoodCreator.getfoodobjectsbyrestaurantid(id));

        restaurant.setRate(RateModule.getraterestaurantbyid(id));

        return restaurant;
    }

    public static ArrayList<Restaurant> CreateRestaurantsObjectlike(String like){
        ArrayList<Integer> data = RestaueantModule.getRestaurantslike(like);
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        for (Integer res: data ) {
            Restaurant restaurant = CreateRestaurantObject(res);
            restaurants.add(restaurant);
        }
        return restaurants;
    }


}
