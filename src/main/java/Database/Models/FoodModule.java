package Database.Models;

import Database.Connector;
import Objects.Food;
import Objects.Restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodModule {

    public static ArrayList<Integer> getfoodsbyrestaurantid(int id){
        Connection connection = Connector.connector.connect();
        ArrayList<Integer> foodids = new ArrayList<>();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT id FROM foods WHERE restaurant_id = " + id +";").executeQuery();

            while (resultSet.next()){
                foodids.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }

        return foodids;
    }

    public static ArrayList<String> getfoodbyid(int id){
        Connection connection = Connector.connector.connect();
        ArrayList<String> food = new ArrayList<>();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * FROM foods WHERE id = " + id +";").executeQuery();

            if (resultSet.next()){
                food.add(String.valueOf(resultSet.getInt(1)));
                food.add(resultSet.getString(2));
                food.add(String.valueOf(resultSet.getInt(3)));
                food.add(resultSet.getString(4));
                food.add(String.valueOf(resultSet.getDouble(5)));
                food.add(String.valueOf(resultSet.getInt(6)));
                food.add(String.valueOf(resultSet.getInt(7)));
                food.add(String.valueOf(resultSet.getInt(8)));
                if(resultSet.getBoolean(9))
                    food.add("true");
                else
                    food.add("false");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }

        return food;
    }

    public static void editfoodname(String newname){
        Connector.Raw("UPDATE foods SET name ='" + newname +"' WHERE id = " + Food.infood.getId() +";");
    }

    public static void editfoodprice(int newprice){
        Connector.Raw("UPDATE foods SET price =" + newprice +" WHERE id = " + Food.infood.getId() +";");
    }

    public static void changetoactivebyid(int id){
        Connector.Raw("UPDATE foods SET status = true WHERE id = " + id +";");
    }
    public static void changetoactive(){
        Connector.Raw("UPDATE foods SET status = true WHERE id = " + Food.infood.getId() +";");
    }
    public static void changetodeactive(){
        Connector.Raw("UPDATE foods SET status = false WHERE id = " + Food.infood.getId() +";");
    }
    public static void changetodeactivebyid(int id){
        Connector.Raw("UPDATE foods SET status = false WHERE id = " + id +";");
    }

    public static void deletefood(int id){
        Connector.Raw("DELETE FROM foods WHERE id = " + id +";");
        Food.infood = null;
    }

    public static void setdiscount(int newdiscount){
        Connector.Raw("UPDATE foods SET discount =" + newdiscount +" WHERE id = " + Food.infood.getId() +";");
    }


    public static void updaterate() {
        Connector.Raw("UPDATE foods SET rate =" + Food.infood.getRate() +" numrate = " + Food.infood.getNumrate() + " WHERE id = " + Food.infood.getId() +";");
    }

    public static void addFoodtoDB(String name, int price, int type) {
        Connector.Raw("INSERT INTO foods (name,restaurant_id,price,type) VALUES ('"+ name  + "'," + Restaurant.inrestaurant.getId() +"," + price +"," + type + ");");
    }

    public static ArrayList<Integer> getFoodslike(String like) {
        ArrayList<Integer> foods = new ArrayList<>();
        Connection connection = Connector.connector.connect();
        ResultSet resultSet;
        try {
            resultSet = connection.prepareStatement("SELECT id FROM foods WHERE name LIKE '%"+ like +"%';").executeQuery();
            while (resultSet.next()){
                foods.add(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return foods;
    }
}
