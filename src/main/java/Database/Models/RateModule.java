package Database.Models;

import Database.Connector;
import Objects.Food;
import Objects.Restaurant;
import Objects.UserController.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RateModule {
    public static void setraterestaurant(int rate) {
        Connector.Raw("INSERT INTO rates (user,food_id,restaurant_id,rate) VALUES (" + User.logger.getid() + ",null,"+ Restaurant.inrestaurant.getId() +"," + rate + ");");
        Restaurant.inrestaurant.setRate(getraterestaurantbyid(Restaurant.inrestaurant.getId()));
    }

    public static void setratefood(int rate) {
        Connector.Raw("INSERT INTO rates (user,food_id,restaurant_id,rate) VALUES (" + User.logger.getid() + ","+ Food.infood.getId() +",null," + rate + ");");
        Food.infood.setRate(getratefoodbyid(Food.infood.getId()));
    }

    public static double getraterestaurantbyid(int id) {
            Connection connection = Connector.connector.connect();
            int numrate = 0;
            double rate = 0;
            try {
                ResultSet resultSet;
                resultSet = connection.prepareStatement("SELECT * FROM rates WHERE restaurant_id = " + id +";").executeQuery();

                while (resultSet.next()){
                    numrate++;
                    rate += resultSet.getInt(5);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                Connector.connector.disconnect();
            }

            if(numrate !=0)
                return rate / numrate;
            else 
                return 2.5;
    }
    public static double getratefoodbyid(int id) {
        Connection connection = Connector.connector.connect();
        int numrate = 0;
        double rate = 0;
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * FROM rates WHERE food_id = " + id +";").executeQuery();

            while (resultSet.next()){
                numrate++;
                rate += resultSet.getInt(5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }

        if(numrate !=0)
            return rate / numrate;
        else
            return 2.5;
    }

    public static void editratefood(int rate) {
        Connector.Raw("UPDATE rates SET rate = " + rate + " WHERE user = " + User.logger.getid() + " AND food_id = "+ Food.infood.getId() +";");
    }

    public static boolean hasratedrestaurant(int id){
        Connection connection = Connector.connector.connect();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * FROM rates WHERE restaurant_id = " + id +" AND user = "+ User.logger.getid() +";").executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return false;
    }

    public static boolean hasratedfood(int id){
        Connection connection = Connector.connector.connect();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * FROM rates WHERE food_id = " + id +" AND user = "+ User.logger.getid() +";").executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return false;

    }

    public static void editraterestaurant(int rate) {
        Connector.Raw("UPDATE rates SET rate = " + rate + " WHERE user = " + User.logger.getid() + " AND restaurant_id = "+ Restaurant.inrestaurant.getId() +";");
    }
}
