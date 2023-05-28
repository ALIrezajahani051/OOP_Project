package Objects.InputController;
import Database.Models.FoodTypeModule;
import Objects.Comment;
import Objects.Food;
import Objects.FoodType;
import Objects.RestaurantPanel;

import java.util.ArrayList;

public class RestaurantInputController {
    public static void showLocation() {
        System.out.println("its ok showlocation");
        System.out.println("this is address:");
        System.out.println(RestaurantPanel.Panel.showAddress());
    }

    public static void editLocation() {

        System.out.println("its ok editaddress");
        String newadd = "";
        while (newadd.equals("")){
            System.out.println("inter your new address: ");
            newadd = InputController.getLine();
        }

        RestaurantPanel.Panel.editAddress(newadd);
        System.out.println("edited successfully");

    }

    public static void showFoodType() {
        System.out.println("its ok showfoodtype");
    }


    public static void selectfood(){

        System.out.println("id      name       foodtype      price      data      rate      status");
        ArrayList<Food> foods = RestaurantPanel.Panel.showFoods();
        for (Food food: foods) {
            System.out.println(food.getId() +"      " + food.getName() + "      " + FoodTypeModule.getbyid(food.getFoodtype_id()) +"      "+food.getPrice() + "      "+ food.getDate() +"      "+ food.getRate() + "      " + food.getStatus());
        }
        System.out.println("inter a id for go to panel");
        int id = Integer.parseInt(InputController.getLine());
        RestaurantPanel.selectfood(id);
        System.out.println("you are in Panel Food " + Food.infood.getName());

        FoodInputController.showactionlist();
    }

    public static void showactionlist(){
        System.out.println("for every action please inter a number:");
        System.out.println("#1    for edit location");
        System.out.println("#2    for show location");
        System.out.println("#3    for select food");
        System.out.println("#4    for add food");
        System.out.println("#5    for delete food");
        System.out.println("#6    for active food in menu");
        System.out.println("#7    for deactive food in menu");
        System.out.println("#8    for mordan bedon dard :) ");
        System.out.println("#9    for show foods ");

        try {
            int num = Integer.parseInt(InputController.getLine());

            switch (num){
                case 4 -> addfood();
                case 9 -> selectfood();
            }



        }catch (Exception e){
            System.out.println("invalid");
        }
    }

    private static void addfood() {
        System.out.println("its ok addfood");

        try {
            String[] fields = new String[3];
            String[] responses = {"name","price","type"};
            ArrayList<String[]> foodtypes = FoodTypeModule.getFoodTypes();
            int i = 0;
            while (i<3) {
                if(i == 2){
                    System.out.println("select type");
                    for (String[] type: foodtypes) {
                        System.out.println("# " + type[0] + "    " + type[1]);
                    }
                }
                System.out.print(responses[i] + " -> ");
                String field = InputController.getLine();
                if(!field.equals("")){
                    fields[i] = field;
                    i++;
                }else {
                    System.out.println("this field is required");
                }
            }
            RestaurantPanel.Panel.addFood(fields[0],Integer.parseInt(fields[1]),Integer.parseInt(fields[2]));
            // SET a BACK TODO
            System.out.println("you add food successfuly");
            showactionlist();
            /////////
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void showcomments(){
        System.out.println("this is comments");

    }

}
