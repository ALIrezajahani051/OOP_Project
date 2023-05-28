package Objects;

import java.util.ArrayList;

public class Food {

    private String name,date;
    private int discount = 0;
    private int restaurant_id;
    private int foodtype_id,numrate;
    private int id;

    private boolean status = false;
    private double price;

    public void setNumrate(int numrate) {
        this.numrate = numrate;
    }

    public boolean isStatus() {
        return status;
    }

    private double rate;

    private ArrayList<Comment> comments;

    public static Food infood = new Food();

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setFoodtype_id(int foodtype_id) {
        this.foodtype_id = foodtype_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getDiscount() {
        return discount;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public int getFoodtype_id() {
        return foodtype_id;
    }

    public int getId() {
        return id;
    }


    public double getPrice() {
        return price;
    }

    public boolean getStatus() {
        return status;
    }





    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }




    public void setPrice(double price) {
        this.price = price;
    }

    public void setFoodType(int foodtype_id) {
        this.foodtype_id = foodtype_id;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public Comment getComment(int id){
        Comment comment = null;
        for (Comment cmt: this.getComments()) {
            if(cmt.getId() == id)
                comment = cmt;
        }
        return comment;
    }

    public void setRate(double aDouble) {
        this.rate = aDouble;
    }

    public double getRate() {
        return  this.rate;
    }

    public int getNumrate() {
        return this.numrate;
    }
}
