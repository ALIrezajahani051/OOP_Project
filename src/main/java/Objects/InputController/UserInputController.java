package Objects.InputController;

import Database.Models.FoodTypeModule;
import Objects.Food;
import Objects.Restaurant;
import Objects.RestaurantPanel;
import Objects.SearchController;

import java.util.ArrayList;
import java.util.HashMap;

public class UserInputController {


    public static void search(){
        System.out.println("this is search");
        String field = "";
        while (field.equals("")){
            System.out.print("your search ->  ");
            field = InputController.getLine();
        }
        ArrayList<Restaurant> restaurantslike = SearchController.searchinrestaurants(field);
        System.out.println("between restaurant");
        if(restaurantslike.size() == 0)
            System.out.println("there is no restaurant with this search");
        else {
            System.out.println("id            name            type            rate");
            for (Restaurant restaurant: restaurantslike) {
                System.out.println(restaurant.getId() +".            " + restaurant.getName() + "            " + restaurant.getFoodType() + "            " + restaurant.getRate());
            }
        }

        ////////////

        ArrayList<Food> foodslike = SearchController.searchinfoods(field);
        System.out.println("between foods");
        if(foodslike.size() == 0)
            System.out.println("there is no foods with this search");
        else {
            System.out.println("id      name       foodtype      price       rate");
            for (Food food: foodslike) {
                System.out.println(food.getId() +".      " + food.getName() + "      " + FoodTypeModule.getbyid(food.getFoodtype_id()) +"      "+food.getPrice() + "      "+ food.getRate());
            }
        }


    }
}
