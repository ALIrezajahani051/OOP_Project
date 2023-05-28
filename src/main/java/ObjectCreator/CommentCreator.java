package ObjectCreator;

import Database.Models.CommentModule;
import Database.Models.FoodModule;
import Database.Models.RateModule;
import Database.Models.UserModule;
import Objects.Comment;
import Objects.Food;

import java.util.ArrayList;

public class CommentCreator {

//    public static Food getcommentbyid(int id){
//        ArrayList<String> data = CommentModule.getcbyid(id);
//
//        Food food = new Food();
//        food.setId(Integer.parseInt(data.get(0)));
//        food.setName(data.get(1));
//        food.setDiscount(Integer.parseInt(data.get(2)));
//        food.setDate(data.get(3));
//        food.setRate(Double.parseDouble(data.get(4)));
//        food.setRestaurant_id(Integer.parseInt(data.get(5)));
//        food.setPrice(Integer.parseInt(data.get(6)));
//        food.setFoodType(Integer.parseInt(data.get(7)));
//        if(data.get(8).equals("true"))
//            food.setStatus(true);
//        else
//            food.setStatus(false);
//
//        food.setRate(RateModule.getratefoodbyid(id));
//        food.setComments(CommentCreator.getcommentfoodbyid(food.getId()));
//        return food;
//    }
    public static ArrayList<Comment> getcommentfoodbyid() {
        ArrayList<ArrayList<String>> data = CommentModule.getcommentsbyfoodid();
        ArrayList<Comment> comments = new ArrayList<>();
        for (ArrayList<String> cmt: data) {
            Comment comment = new Comment();
            comment.setId(Integer.parseInt(cmt.get(0)));
            comment.setComment(cmt.get(1));
            comment.setFood_id(Integer.parseInt(cmt.get(2)));
            comment.setUser_id(UserModule.getUser(Integer.parseInt(cmt.get(3))).getUsername());
            comment.setReply(Integer.parseInt(cmt.get(4)));
            comment.setRes_id(Integer.parseInt(cmt.get(5)));
            comments.add(comment);
        }
        return comments;
    }
}
