package Objects;

import ObjectCreator.FoodCreator;
import ObjectCreator.RestaurantCreator;

import java.util.ArrayList;

public class SearchController {




    public static ArrayList<Restaurant> searchinrestaurants(String like){
        return RestaurantCreator.CreateRestaurantsObjectlike(like);
    }

    public static ArrayList<Food> searchinfoods(String like){
        return FoodCreator.CreateFoodsObjectlike(like);
    }


}
