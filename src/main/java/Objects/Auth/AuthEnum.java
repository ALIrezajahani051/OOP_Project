package Objects.Auth;

public enum AuthEnum {
    DOES_DONT_EXIST_USERNAME("username does not exist"),
    NOT_EQUAL_PASS("your password is wrong"),
    DONE_LOGIN("you loggined successfully"),
    NOT_EQUAL_ANS("your ans is wrong"),
    USERNAME_ALREADY_EXIST("username already exist"),
    DONE("done!"),
    Reqired("this field is required"), OK("ok"),
    DONE_LOGOUT("logout successfully"),
    REPEAT_PASS("Your password is the same as the previous password "),
    PASSWORD_CHANGED("your password changed successfully"),
    DOES_DONT_EXIST_ANSWER("you don't set a answer i'm sorry ))):  ");

    public String value;

    AuthEnum(String value){
        this.value = value;
    }

}
