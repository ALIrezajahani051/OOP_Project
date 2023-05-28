package Database.Models;

import Database.Connector;
import Objects.Restaurant;
import Objects.UserController.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class RestaueantModule {

    public static ArrayList<String> getrestaurantbyid(int id){
            ArrayList<String> data = new ArrayList<>();
            Connection connection = Connector.connector.connect();
            ResultSet resultSet;
            try {
                resultSet = connection.prepareStatement("SELECT * from restaurants WHERE id = " + id + ";").executeQuery();
                if (resultSet.next()){

                    data.add(String.valueOf(resultSet.getInt(1)));
                    data.add(resultSet.getString(2));
                    data.add(resultSet.getString(3));
                    data.add(resultSet.getString(4));
                    if(resultSet.getBoolean(5))
                        data.add("true");
                    else
                        data.add("false");
                    data.add(String.valueOf(resultSet.getInt(6)));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                Connector.connector.disconnect();
            }
            return data;
    }

    public static void editaddress(String newaddress){
        Connector.Raw("UPDATE restaurants SET address = '" + newaddress + "' WHERE id = " + Restaurant.inrestaurant.getId() + ";");
    }

    public static void editfoodtype(String newaddress){
        Connector.Raw("UPDATE restaurants SET address = '" + newaddress + "' WHERE id = " + Restaurant.inrestaurant.getId() + ";");
    }


    public static ArrayList<HashMap<String, String>> getRestaurantsAdmin(){
        ArrayList<HashMap<String,String>> restaurants = new ArrayList<>();
        Connection connection = Connector.connector.connect();
        ResultSet resultSet;
        try {
            resultSet = connection.prepareStatement("SELECT * from restaurants WHERE admin = " + User.logger.getId() + ";").executeQuery();
            while (resultSet.next()){
                HashMap<String,String> restaurant = new HashMap<>();
                restaurant.put("id",String.valueOf(resultSet.getInt(1)));
                restaurant.put("name",resultSet.getString(2));
                restaurant.put("foodtype",resultSet.getString(3));
                restaurant.put("address",resultSet.getString(4));
                if(resultSet.getBoolean(5))
                    restaurant.put("status","true");
                else
                    restaurant.put("status","false");
                restaurant.put("admin",String.valueOf(resultSet.getInt(6)));

                restaurants.add(restaurant);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return restaurants;
    }

    public static ArrayList<Integer> getRestaurantslike(String like){
        ArrayList<Integer> restaurants = new ArrayList<>();
        Connection connection = Connector.connector.connect();
        ResultSet resultSet;
        try {
            resultSet = connection.prepareStatement("SELECT id FROM restaurants WHERE name LIKE '%"+ like +"%';").executeQuery();
            while (resultSet.next()){
                restaurants.add(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return restaurants;
    }


    public static ArrayList<Restaurant> getAllRestaurants(){
        Connection connection = Connector.connector.connect();
        ResultSet resultSet;
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try {
            resultSet = connection.prepareStatement("SELECT * from restaurants ;").executeQuery();
            while (resultSet.next()){
                Restaurant restaurant = new Restaurant();

                restaurant.setId(resultSet.getInt(1));
                restaurant.setName(resultSet.getString(2));
                restaurant.setFoodType(resultSet.getString(3));
                restaurant.setAddress(resultSet.getString(4));
                restaurant.setStatus(resultSet.getBoolean(5));
                restaurant.setAdmin(resultSet.getInt(6));
                //restaurant.setFoods(FoodModule.getfoodsbyrestaurantid(resultSet.getInt(1)));

                restaurants.add(restaurant);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return restaurants;
    }


}
