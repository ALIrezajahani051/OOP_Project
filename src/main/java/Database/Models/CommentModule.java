package Database.Models;

import Database.Connector;
import Objects.*;
import Objects.UserController.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentModule {
    public static ArrayList<ArrayList<String>> getcommentsbyfoodid(){
        Connection connection = Connector.connector.connect();
        ArrayList<ArrayList<String>> comments = new ArrayList<>();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * FROM comments WHERE food = " + Food.infood.getId() +";").executeQuery();

            while (resultSet.next()){
                ArrayList<String> comment = new ArrayList<>();
                comment.add(String.valueOf(resultSet.getInt(1)));
                comment.add(resultSet.getString(2));
                comment.add(String.valueOf(resultSet.getInt(3)));
                comment.add(String.valueOf(resultSet.getInt(4)));
                comment.add(String.valueOf(resultSet.getInt(5)));
                comment.add(String.valueOf(resultSet.getInt(6)));

                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }

        return comments;
    }

    public static ArrayList<Comment> getcommentsbyrestaurantid(){
        Connection connection = Connector.connector.connect();
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * FROM comments WHERE restaurant = " + Restaurant.inrestaurant.getId() +";").executeQuery();

            while (resultSet.next()){
                Comment comment = new Comment();
                comment.setId(resultSet.getInt(1));
                comment.setComment(resultSet.getString(2));
                comment.setFood_id(resultSet.getInt(3));
                comment.setUser_id(String.valueOf(resultSet.getInt(4)));
                comment.setReply(resultSet.getInt(5));

                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connector.connector.disconnect();
        }

        return comments;
    }

    public static void addcommentforrestaurant(String comment){
        Connector.Raw("INSERT INTO comments (comment,restaurant,user) VALUES ('" + comment + "'," + Restaurant.inrestaurant.getId() +"," + User.logger.getid() + ");");
    }

    public static void editcommentforrestaurant(String comment,int id){
        Connector.Raw("UPDATE comments SET comment = '" + comment + "' WHERE restaurant = " + Restaurant.inrestaurant.getId() + " AND id = " + id +";");
    }

    public static void addcommentforfood(String comment){
        Connector.Raw("INSERT INTO comments (comment,food,user,answer) VALUES ('" + comment + "'," + Food.infood.getId() +"," + User.logger.getid() + ")");
    }

    public static void editcommentforfood(String comment,int id){
        Connector.Raw("UPDATE comments SET comment = '" + comment + "' WHERE restaurant = " + Restaurant.inrestaurant.getId() + " AND id = " + id +";");
    }
}
