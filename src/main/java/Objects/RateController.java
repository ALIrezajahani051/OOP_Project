package Objects;

import Database.Models.RateModule;
import Objects.UserController.User;

public class RateController {

    User user;
    public RateController(User user){
        this.user = user;
    }
    public static void setraterestaurant(int rate,int id){
        RateModule.setraterestaurant(rate);
    }

    public static void editraterestaurant(int rate){
        RateModule.editraterestaurant(rate);
    }

    public static void setratefood(int rate){
        RateModule.setratefood(rate);
    }

    public static void editratefood(int rate){
        RateModule.editratefood(rate);
    }

    public static double getrate(int id) {
        return RateModule.getraterestaurantbyid(id);
    }
}
