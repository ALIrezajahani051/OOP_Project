package Objects.InputController;
import Database.Models.FoodTypeModule;
import Objects.Comment;
import Objects.Food;
import Objects.FoodPanel;
import Objects.RestaurantPanel;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class FoodInputController {
    public static void showactionlist(){


        System.out.println("for every action please inter a number:");
        System.out.println("#1    for edit name");
        System.out.println("#2    for edit type");
        System.out.println("#3    for edit price");
        System.out.println("#4    for add menu");
        System.out.println("#5    for delete food");
        System.out.println("#6    for show comments");
        System.out.println("#7    for set discount");
        System.out.println("#8    for show comments");

        try {
            int num = Integer.parseInt(InputController.getLine());
            ///
            switch (num){
                case 1 -> editname();
                case 7 -> setdiscount();
                case 8 -> showcomments();
            }
        }catch (Exception e){
            System.out.println("invalid");
        }
    }

    private static void editname() {
        String name = InputController.getLine();
        FoodPanel.Panel.editfoodname(name);
        System.out.println("name edited successfult");
        showactionlist();
    }

    private static void setdiscount(){
        try {
            String[] fields = new String[2];
            String[] responses = {"dicount","time"};
            int i = 0;
            while (i<2) {
                System.out.print(responses[i] + " -> ");
                String field = InputController.getLine();
                if(!field.equals("")){
                    if(i == 1 && Integer.parseInt(field) > 50){
                        System.out.println("your percent must be between 1 and 50");
                    }
                    fields[i] = field;
                    i++;
                }else {
                    System.out.println("this field is required");
                }
            }




            // SET a BACK TODO
            System.out.println("you discount food successfuly");
            sleep(500);
            showactionlist();
            /////////
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void showcomments(){
        System.out.println("this is comments");

        ArrayList<Comment> commends = FoodPanel.Panel.showcomments();
        for (Comment cmt: commends) {
            System.out.println(cmt.getUser_id() + " :");
            System.out.println("    " + cmt.getComment());
        }

        showactionlist();
    }
}
