package Database.Models;

import Database.Connector;
import Objects.*;
import Objects.UserController.NormalUser;
import Objects.UserController.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderModule {

    // id set nshde


    // when you want to delete a food check there arnt an active
    public static boolean checkExistActiveOrderWithFood(int id){
        Connection connection = Connector.connector.connect();
        boolean has = false;
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * FROM orders WHERE food = "+ id +" AND status = 1;").executeQuery();
            if (resultSet.next())
                has = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return has;
    }



    // when you want to delete or edit a restaurant check there arnt an active order
    public static boolean checkExistActiveOrderWithRestaurant(){
        boolean has = false;
        for (Food food : Restaurant.inrestaurant.getFoods()) {
            if(checkExistActiveOrderWithFood(food.getId())){
                has = true;
                break;
            }
        }
        return has;
    }

    public static ArrayList<Order> getOrderRestaurant(){
        Connection connection = Connector.connector.connect();
        ArrayList<Order> orders = new ArrayList<>();
        ResultSet resultSet;
        try {
            for (Food food:Restaurant.inrestaurant.getFoods()) {
                resultSet = connection.prepareStatement("SELECT * FROM orders WHERE food = "+ food.getId() +" WHERE status = 1;").executeQuery();
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setFood_id(resultSet.getInt(2));
                order.setUser_id(resultSet.getInt(3));
                order.setPk_order(resultSet.getString(4));

                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return orders;
    }


    //TODO
    public static void addToCartDB(int food_id) {
    //    Food food = FoodModule.getfoodbyid(food_id);
//        String lpk = UserModule.getLastPK();
//        Connector.Raw("INSERT INTO orders (food,user,pk_order) VALUES ('"+  food.getId()  + "'," + NormalUser.logger.getId() +"," + 1 + ",'"+ lpk + "');");
//        // update pk_order
//        Connector.Raw("UPDATE pk_orders SET price = price + " +  food.getPrice() +" WHERE pk = '"+ lpk +"';\n");
    }

    public static ArrayList<Order> getUserCart() {
        Connection connection = Connector.connector.connect();
        ArrayList<Order> orders = new ArrayList<>();
        ResultSet resultSet;
        try {
          resultSet = connection.prepareStatement("SELECT * from orders WHERE pk_order = "+ UserModule.getLastPK() + ";").executeQuery();
          while (resultSet.next()){
              Order order = new Order();

              order.setFood_id(resultSet.getInt(2));
              order.setUser_id(resultSet.getInt(3));
              order.setPk_order(resultSet.getString(4));

              orders.add(order);
          }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return orders;
    }

    public static int getTotalPrice() {
        Connection connection = Connector.connector.connect();
        int price = 0;
        ResultSet resultSet;
        try {
            resultSet = connection.prepareStatement("SELECT total_price from pk_orders WHERE pk= "+ UserModule.getLastPK() + ";").executeQuery();
            if(resultSet.next()){
                price = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return price;
    }

    public static void UpdateTOConfirm(){
        Connector.Raw("UPDATE users SET credit = credit - " + OrderModule.getTotalPrice() + " WHERE id = '" + User.logger.getId() + "';");
        Connector.Raw("UPDATE pk_orders SET status = " + 0 + " WHERE pk = '" + UserModule.getLastPK() + "';");
        Connector.Raw("INSERT INTO pk_orders (pk,user) VALUES ('"+ GenericUniqcode.generateRandomString() + "'," + User.logger.getid() + ");");
    }

    public static HashMap<String, ArrayList<Order>> getHistory() {
        Connection connection = Connector.connector.connect();
        HashMap<String,ArrayList<Order>> history = new HashMap<>();
        ResultSet resultSet,resultSet1;
        try {
                resultSet = connection.prepareStatement("SELECT * FROM pk_orders WHERE user = " + User.logger.getId() + ";").executeQuery();
                while (resultSet.next()){
                    String pk_order = resultSet.getString(2);
                    ArrayList<Order> orders = new ArrayList<>();
                    resultSet1 = connection.prepareStatement("SELECT * FROM orders WHERE pk_order = " + pk_order + ";").executeQuery();
                    while (resultSet1.next()){
                        Order order = new Order();
                        order.setId(resultSet.getInt(1));
                        order.setFood_id(resultSet.getInt(2));
                        order.setUser_id(resultSet.getInt(3));
                        order.setPk_order(resultSet.getString(4));

                        orders.add(order);
                    }

                    history.put(pk_order,orders);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }
        return history;
    }
}
