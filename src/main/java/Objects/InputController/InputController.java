package Objects.InputController;

import Objects.Auth.AuthEnum;
import Objects.Auth.ChangePassword;
import Objects.UserController.User;

import java.util.Scanner;

public class InputController {

    public static Scanner scanner = new Scanner(System.in);

    public static Commend getCommand(){
        return new Commend(scanner.nextLine());
    }
    public static String getLine(){
        return scanner.nextLine();
    }
    public static String getPosition(){
        return User.getLogger().getPosition();
    }

    public static void test(){
        System.out.println("ok");
    }


    public static void luncher(){
        Commend commend = InputController.getCommand();
        System.out.println(commend.getType());


        switch (commend.getType()){
            case TEST -> test();


            case SINGUP -> LoginInputController.singup(commend); // fix
            case LOGIN -> LoginInputController.login(commend); // fix
            case Logout -> LoginInputController.logout(); //fix
            case FORGOT_PASSWORD -> LoginInputController.forgot(commend); //fix
            case CHANGE_PASS -> changePass(); //fix   *in logged mode
            case CHANGE_ANSWER -> addOrChangeAnswer();

            case SELECT_FOOD -> RestaurantInputController.selectfood(); // fix
            case SHOW_RESTAURANTS -> AdminInputController.showAdminRestaurants(); // fix
            case SELECT_RESTAURANT -> AdminInputController.selectRestaurant(); // fix
            case SHOW_LOCATION -> RestaurantInputController.showLocation(); // fix
            case EDIT_LOCATION -> RestaurantInputController.editLocation(); //fix
            case SHOW_FOODTYPE -> RestaurantInputController.showFoodType();
            case SEARCH -> UserInputController.search();
//            .
//            .
//            .
//




        }

        InputController.luncher();
    }

    public static void ExitChecker(String input) {
        if(input.equals("EXIT")){
            System.out.println("are you sure?   y or every / n ");
            String inp = InputController.getLine();
            if(!inp.equals("n"))
                System.exit(0);
        }
    }


    public static void changePass() {
        System.out.println("its ok changepass in userpanel   admin/user");


        try {
            String[] fields = new String[1];
            String[] responses = {"*password"};
            int i = 0;
            while (i<1) {
                System.out.print(responses[i] + " -> ");
                String field = InputController.getLine();
                //InputController.ExitChecker(field);
                AuthEnum e = ChangePassword.validation(responses[i],field);
                if(e == AuthEnum.OK){
                    fields[i] = field;
                    i++;
                }else {
                    System.out.println(e.value);
                }
            }

            AuthEnum e = ChangePassword.changePassword(User.logger.getUsername(),fields[0]);

            System.out.println(e.value);
            if(e == AuthEnum.REPEAT_PASS){
                changePass();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void addOrChangeAnswer(){
        ///
    }
}
