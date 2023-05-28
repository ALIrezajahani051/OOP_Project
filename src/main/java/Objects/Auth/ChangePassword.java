package Objects.Auth;

import Database.Models.UserModule;
import Objects.UserController.User;

import java.security.NoSuchAlgorithmException;

public class ChangePassword {

    public static AuthEnum changePassword(String username, String password) throws NoSuchAlgorithmException {
        password = Hasher.getHasher(password);

        if(password.equals(UserModule.getPassword(username))){
            return AuthEnum.REPEAT_PASS;
        }
        UserModule.changePass(username,password);
        return AuthEnum.PASSWORD_CHANGED;
    }
    public static AuthEnum validation(String type, String field) {
        if(type.charAt(0) == '*' && (field == null || field.equals(""))){
            return AuthEnum.Reqired;
        }


        return AuthEnum.OK;
    }


}
