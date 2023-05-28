package Objects.InputController;


import Database.Models.UserModule;
import Objects.Auth.*;
import Objects.UserController.User;

public class LoginInputController {
    public static void login(Commend commend) {
        System.out.println("its ok login");

        try {
            String[] fields = new String[2];
            String[] responses = {"username","password"};
            int i = 0;
            while (i<2) {
                System.out.print(responses[i] + " -> ");
                String field = InputController.getLine();
                //InputController.ExitChecker(field);
                AuthEnum e = Login.validation(responses[i],field);
                if(e == AuthEnum.OK){
                    fields[i] = field;
                    i++;
                }else {
                    System.out.println(e.value);
                }
            }

            AuthEnum e = Login.login(fields[0],fields[1]);
            // SET a BACK TODO
            System.out.println(e.value);
            if(e != AuthEnum.DONE_LOGIN){
                login(commend);
            }
            /////////
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void singup(Commend commend) {
        System.out.println("its ok singup");


        if(commend.getSplited()[1].equals("admin") || commend.getSplited()[1].equals("user")){
            try {
                String[] fields = new String[6];
                String[] responses = {"*username","*password","name","family","securite question"};
                System.out.println("Please fill in. ( Items with an * are required )");
                int i = 0;
                while (i<5) {
                    System.out.print(responses[i] + " -> ");
                    String field = InputController.getLine();
                    //InputController.ExitChecker(field);
                    // SET a BACK TODO
                    AuthEnum e = Singup.validation(responses[i],field);
                    if(e == AuthEnum.OK){
                        fields[i] = field;
                        i++;
                    }else {
                        System.out.println(e.value);
                    }
                }
                fields[5] = commend.getSplited()[1];
                Singup.singup(fields);
                System.out.println(AuthEnum.DONE_LOGIN.value);
                /////////
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            InvalidCommandException.InvalidTypePosition();
        }
    }

    public static void logout() {
        System.out.println("its ok logout");
        User.logger = null;
        System.out.println(AuthEnum.DONE_LOGOUT.value);
    }

    public static void forgot(Commend commend) {
        System.out.println("its ok forgot");

            try {
                String[] fields = new String[2];
                String[] responses = {"*username","*answer"};
                System.out.println("Please fill in. ( Items with an * are required )");
                int i = 0;
                while (i<fields.length) {
                    System.out.print(responses[i] + " -> ");
                    String field = InputController.getLine();
                    //InputController.ExitChecker(field);
                    // SET a BACK TODO
                    AuthEnum e = ForgotPassword.validation(responses[i],field);
                    if(e == AuthEnum.OK){
                        fields[i] = field;
                        i++;
                    }else {
                        System.out.println(e.value);
                        return;
                    }
                }
                
                AuthEnum msg = ForgotPassword.forgotPassword(fields[0],fields[1]);
                if(msg != AuthEnum.DONE){
                    System.out.println(msg.value);
                }else {
                    changePassword(fields[0]);
                }

                /////////
            }catch (Exception e){
                e.printStackTrace();
            }

        
    }

    private static void changePassword(String username) {
        System.out.println("its ok changepassword");


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

            AuthEnum e = ChangePassword.changePassword(username,fields[0]);
            System.out.println(e.value);
            if(e == AuthEnum.REPEAT_PASS){
                changePassword(username);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
