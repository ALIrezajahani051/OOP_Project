package Objects;

import Database.Models.FoodModule;
import Database.Models.OrderModule;
import Database.Models.RateModule;
import Database.Models.RestaueantModule;
import ObjectCreator.RestaurantCreator;

import java.util.ArrayList;

public class RestaurantPanel {

    private Restaurant restaurant;

    public static RestaurantPanel Panel;

    public RestaurantPanel(Restaurant restaurant){
        this.restaurant = restaurant;
    }



    public String showAddress(){
        return this.restaurant.getAddress();
    }

    public void editAddress(String address){
        RestaueantModule.editaddress(address);
        this.restaurant.setAddress(address);
    }

    private String showFoodtype(){
        return this.restaurant.getFoodType();
    }

    private void editFoodtype(String foodtype){
        // edit
        RestaueantModule.editfoodtype(foodtype);
        this.restaurant.setFoodType(foodtype);
    }

    private boolean checkExistActiveOrder(){
        return OrderModule.checkExistActiveOrderWithRestaurant();
    }


    // TODO date discount
    public void addFood(String name,int price,int type){
        // set to database and objecy
        FoodModule.addFoodtoDB(name,price,type);
        Food food = new Food();
        food.setName(name);
        food.setPrice(price);
        food.setFoodType(type);
        this.restaurant.addFood(food);

    }

    public ArrayList<Food> showActiveFoods(){
        return this.restaurant.getActiveFoods();
    }

    public ArrayList<Food> showFoods(){
        return this.restaurant.getFoods();
    }


    private ArrayList<Order> showOrders(){
        // get food from database
        return OrderModule.getOrderRestaurant();
    }


    private double showRate(){
        return RateModule.getraterestaurantbyid(this.restaurant.getId());
    }


    ///// QUICK ACCESS
    public void addtomenu(int id){
        // change status to true
        FoodModule.changetoactivebyid(id);
        this.restaurant.activeFood(id);
    }

    public void deleteformmenu(int id){
        // change status to false
        FoodModule.changetodeactivebyid(id);
        this.restaurant.deactiveFood(id);
    }
    public void deletefood(int id){
        FoodModule.deletefood(id);
        this.restaurant.deleteFood(id);
    }


    public static void selectfood(int id){
        Food food = RestaurantPanel.Panel.restaurant.getfood(id);
        FoodPanel.Panel = new FoodPanel(food);
        Food.infood = food;
    }

    public static ArrayList<Restaurant> showAllRestaurants(){
        return RestaueantModule.getAllRestaurants();
    }

}
