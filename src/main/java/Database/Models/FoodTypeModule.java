package Database.Models;

import Database.Connector;
import Objects.FoodType;
import Objects.Restaurant;
import Objects.RestaurantPanel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class FoodTypeModule {


    public static ArrayList<String[]> getFoodTypes() {
        Connection connection = Connector.connector.connect();
        ResultSet resultSet;
        ArrayList<String[]> types = new ArrayList<>();
        try {
            resultSet = connection.prepareStatement("SELECT * from foodtypes WHERE restaurant_id = "+ Restaurant.inrestaurant.getId() +";").executeQuery();

            while (resultSet.next()){
                String[] type = new String[2];
                type[0] = String.valueOf(resultSet.getInt(1));
                type[1] = resultSet.getString(2);
                types.add(type);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return types;
    }

    public static String getbyid(int foodtype_id) {
        Connection connection = Connector.connector.connect();
        ResultSet resultSet;
        String ft = null;
        try {
            resultSet = connection.prepareStatement("SELECT type from foodtypes WHERE id = "+ foodtype_id +";").executeQuery();
            if(resultSet.next())
                ft = resultSet.getString(1);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return ft;
    }
}
