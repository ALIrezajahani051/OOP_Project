package Objects.Auth;

import Database.Models.UserModule;

import java.security.NoSuchAlgorithmException;

public class ForgotPassword {

    public static AuthEnum forgotPassword(String username, String answer) throws NoSuchAlgorithmException {
        answer = Hasher.getHasher(answer);

        if(!UserModule.checkHasUsername(username))
            return AuthEnum.DOES_DONT_EXIST_USERNAME;
        if(!answer.equals(UserModule.getAnswer(username)))
            return AuthEnum.NOT_EQUAL_ANS;

        return AuthEnum.DONE;
    }

    public static AuthEnum validation(String respons, String field) {
        if(field == null || field.equals("")){
            return AuthEnum.Reqired;
        }
        if(respons.equals("*username") && !UserModule.checkHasAnswer(field)){
            return AuthEnum.DOES_DONT_EXIST_ANSWER;
        }
        return AuthEnum.OK;
    }
}
