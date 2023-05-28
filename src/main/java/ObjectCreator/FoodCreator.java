package ObjectCreator;

import Database.Models.FoodModule;
import Database.Models.RateModule;
import Database.Models.RestaueantModule;
import Objects.Comment;
import Objects.Food;
import Objects.Restaurant;
import Objects.RestaurantPanel;

import java.util.ArrayList;

public class FoodCreator {

    public static Food getfoodobjectbyid(int id){
        ArrayList<String> data = FoodModule.getfoodbyid(id);

        Food food = new Food();
        food.setId(Integer.parseInt(data.get(0)));
        food.setName(data.get(1));
        food.setDiscount(Integer.parseInt(data.get(2)));
        food.setDate(data.get(3));
        food.setRate(Double.parseDouble(data.get(4)));
        food.setRestaurant_id(Integer.parseInt(data.get(5)));
        food.setPrice(Integer.parseInt(data.get(6)));
        food.setFoodType(Integer.parseInt(data.get(7)));
        if(data.get(8).equals("true"))
            food.setStatus(true);
        else
            food.setStatus(false);

        food.setRate(RateModule.getratefoodbyid(id));
        food.setComments(CommentCreator.getcommentfoodbyid());
        return food;
    }
    public static ArrayList<Food> getfoodobjectsbyrestaurantid(int id) {
        ArrayList<Food> foods = new  ArrayList<>();
        ArrayList<Integer> data = FoodModule.getfoodsbyrestaurantid(id);

        for (int id_lo: data) {
            foods.add(getfoodobjectbyid(id_lo));
        }

        return foods;
    }

    public static ArrayList<Food> getfoodobjectsbyrestaurantid() {
        int id = Restaurant.inrestaurant.getId();
        ArrayList<Food> foods = new  ArrayList<>();
        ArrayList<Integer> data = FoodModule.getfoodsbyrestaurantid(id);

        for (int id_lo: data) {
            foods.add(getfoodobjectbyid(id_lo));
        }

        return foods;
    }

    public static ArrayList<Food> CreateFoodsObjectlike(String like) {
        ArrayList<Integer> data = FoodModule.getFoodslike(like);
        ArrayList<Food> foods = new ArrayList<>();
        for (int id: data) {
            foods.add(getfoodobjectbyid(id));
        }
        return foods;
    }
}
