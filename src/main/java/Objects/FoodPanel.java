package Objects;

import Database.Models.CommentModule;
import Database.Models.FoodModule;
import Database.Models.OrderModule;
import Database.Models.RateModule;
import ObjectCreator.CommentCreator;

import java.util.ArrayList;

public class FoodPanel {


    private Food food;

    public static FoodPanel Panel;

    public FoodPanel(Food food){
      this.food = food;
    }

    public void editfoodname(String newname){
        FoodModule.editfoodname(newname);
        food.setName(newname);
    }

    public void editfoodprice(int newprice){
        FoodModule.editfoodprice(newprice);
        food.setPrice(newprice);
    }

    //////
    public void addtomenu(){
        // change status to true
        FoodModule.changetoactive();
    }

    public void deleteformmenu(){
        // change status to false
        FoodModule.changetodeactive();
        food.setStatus(false);
        Restaurant.inrestaurant.deactiveFood(food.getId());
    }

    public void deletefood(){
        //Restaurant.inrestaurant.Panel.deletefood(food.getId());
        Food.infood = null;
    }


    public boolean checkExistActiveOrder(){
        return OrderModule.checkExistActiveOrderWithFood(food.getId());
    }




    // discount set a event im mysql
    public void setdiscount(int newdiscount){
        FoodModule.setdiscount(newdiscount);
        food.setDiscount(newdiscount);
    }



    public  ArrayList<Comment> showcomments(){
        ArrayList<Comment> comments = CommentCreator.getcommentfoodbyid();
        food.setComments(comments);
        return food.getComments();
    }


    public double showrate(int id){
        return RateModule.getratefoodbyid(id);
    }


}
