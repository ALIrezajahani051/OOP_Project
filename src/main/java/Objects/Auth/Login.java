package Objects.Auth;

import Database.Models.UserModule;
import Objects.AdminPanelController;
import Objects.UserController.User;

import java.security.NoSuchAlgorithmException;

public class Login {
    public static AuthEnum login(String username, String password) throws NoSuchAlgorithmException {
        password = Hasher.getHasher(password);

        if(!UserModule.checkHasUsername(username))
            return AuthEnum.DOES_DONT_EXIST_USERNAME;
        if(!password.equals(UserModule.getPassword(username)))
            return AuthEnum.NOT_EQUAL_PASS;

        if(UserModule.getPosition(username).equals("admin"))
            User.logger = UserModule.getAdmin(username);
        else
            User.logger = UserModule.getNormalUser(username);

        AdminPanelController.Panel = new AdminPanelController(User.logger);
        return AuthEnum.DONE_LOGIN;
    }



    public static void logout(){
        User.logger = null;
    }


    public static AuthEnum validation(String respons, String field) {
        if(field == null || field.equals("")){
            return AuthEnum.Reqired;
        }

        return AuthEnum.OK;
    }
}
