package Objects;

public class Order {

    private int food_id;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String pk_order;


    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPk_order() {
        return pk_order;
    }

    public void setPk_order(String pk_order) {
        this.pk_order = pk_order;
    }


}
