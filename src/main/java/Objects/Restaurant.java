package Objects;


import java.util.ArrayList;

public class Restaurant {

    public static Restaurant inrestaurant;
    private int admin_id;
    private int id;
    private boolean status = true;
    private String name,address,foodtype;
    private String restype;

    public void setRate(double rate) {
        this.rate = rate;
    }

    private double rate;

    private ArrayList<Food> foods = new ArrayList<>();

    private ArrayList<Comment> comments = new ArrayList<>();


    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
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

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Food> getFoods(){
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public String getFoodtype() {
        return foodtype;
    }



    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }


    public int getAdmin_id() {
        return admin_id;
    }



    public int getId() {
        return id;
    }

    public String getRestype() {
        return restype;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }



    public int getAdmin() {
        return admin_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getFoodType() {
        return restype;
    }

    public boolean isStatus() {
        return status;
    }

    public void setAdmin(int admin_id) {
        this.admin_id = admin_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFoodType(String restype) {
        this.restype = restype;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public double getRate() {
        return RateController.getrate(this.getId());
    }



    public Food getfood(int id){
        for (Food food: foods) {
            if(food.getId() == id)
                return food;
        }
        return null;
    }

    public ArrayList<Food> getActiveFoods() {
        ArrayList<Food> foods = new ArrayList<>();
        for (Food food:this.getFoods()) {
            if (food.getStatus())
                foods.add(food);
        }
        return foods;
    }

    public void deleteFood(int id) {
       foods.remove(getfood(id));
    }

    public void deactiveFood(int id) {
        getfood(id).setStatus(false);
    }

    public void activeFood(int id) {
        getfood(id).setStatus(true);
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }


}
