package Objects.Auth;

import Database.Models.UserModule;
import Objects.UserController.User;

import java.security.NoSuchAlgorithmException;

public class Singup {

    public static AuthEnum singup(String name, String family, String username, String password,String securite_answer,String position) throws NoSuchAlgorithmException {

        if(UserModule.checkHasUsername(username)){
            return AuthEnum.USERNAME_ALREADY_EXIST;
        }

        UserModule.singup(name,family,username,Hasher.getHasher(password),Hasher.getHasher(securite_answer),position);
        User.logger = UserModule.getUser(username);
        return AuthEnum.DONE_LOGIN;
    }

//    public static  AuthEnum singup(String[] fields) {
//        // username password name family securite
//        if(UserModule.checkHasUsername(fields[0])){
//            return AuthEnum.USERNAME_ALREADY_EXIST;
//        }
//
//        UserModule.singup(fields[2],fields[3],fields[0],Hasher.getHasher(fields[1]),Hasher.getHasher(fields[4]),fields[5]);
//        User.logger = UserModule.getUser(fields[0]);
//        return AuthEnum.DONE_LOGIN;
//    }


public static  void singup(String[] fields) throws NoSuchAlgorithmException {
    // username password name family securite
    UserModule.singup(fields[2],fields[3],fields[0],Hasher.getHasher(fields[1]),Hasher.getHasher(fields[4]),fields[5]);
    User.logger = UserModule.getUser(fields[0]);
}

    public static AuthEnum validation(String type, String field) {
        if(type.charAt(0) == '*' && (field == null || field.equals(""))){
            return AuthEnum.Reqired;
        }

        if(type.equals("*username") && UserModule.checkHasUsername(field)){
            return AuthEnum.USERNAME_ALREADY_EXIST;
        }

        return AuthEnum.OK;
    }
}
