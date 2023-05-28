package Objects;

public class Rate {

    private int user_id,food_id,res_id,rate;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public int getRes_id() {
        return res_id;
    }

    public int getRate() {
        return rate;
    }
}
