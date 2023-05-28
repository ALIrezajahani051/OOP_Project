package Database.Models;

import Database.Connector;
import Objects.Restaurant;
import Objects.UserController.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminModule {

    private static User adminlogger = User.logger;

    private static ArrayList<Restaurant> getrestaurantsfromdb(){
        Connection connection = Connector.connector.connect();
        ResultSet resultSet;
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try {
            resultSet = connection.prepareStatement("SELECT * from restaurant WHERE admin = " + adminlogger.getid() + ";").executeQuery();
            while (resultSet.next()){
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt(1));
                restaurant.setName(resultSet.getString(2));
                restaurant.setFoodType(resultSet.getString(3));
                restaurant.setAddress(resultSet.getString(4));
                restaurant.setStatus(resultSet.getBoolean(5));
                restaurant.setAdmin(resultSet.getInt(6));

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
