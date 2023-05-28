package Objects;

public class FoodType {

    private String type;
    private int restaurant_id;

    public FoodType(String type, int restaurant_id) {
        this.type = type;
        this.restaurant_id = restaurant_id;
    }

    public String getType() {
        return type;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
