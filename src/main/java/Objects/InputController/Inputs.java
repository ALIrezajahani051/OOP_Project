package Objects.InputController;

public enum Inputs {

    // TODO get a comment without comment answer admin
    LOGIN("login"),
    Logout("logout"),
    SINGUP("add"),
    SINGUP_USER("user"),
    SINGUP_ADMIN("admin"),
    FORGOT_PASSWORD("forgot"),


    SELECT("select"),
    SELECT_RESTAURANT("seres"),
    SELECT_MENU("menu"),
    SHOW("show"),
    SHOW_LOCATION("showloc"),
    SHOW_FOODTYPE("foodtype"),
    EDIT("edit"),
    EDIT_FOODTYPE("foodtype"),
    EDIT_FOOD("food"),
    FOOD_NAME("name"),
    FOOD_PRICE("price"),
    ADD_FOOD("food"),
    DELETE_FOOD("delete"),
    DEACTIVE_FOOD("deactive"),
    ACTIVE_FOOD("active"),
    DISCOUNT("discount"),
    DISPLAY("display"),
    RATINGS("ratings"),
    COMMENTS("comments"),
    RESPONSE("resp"),
    EDIT_RESPONSE("editresp"),
    OPEN("open"),
    ALL("all"),
    ORDER("order"),
    STATUS("status"),
    SENT("sent"),
    READY_SEND("ready"),
    HISTORY("history"),


    SEARCH("search"),
    SEARCH_RESTAURANT("restaurant"),
    ADD_NEW_COMMENT("comment"),
    EDIT_COMMENT("comment"),
    SUBMIT("submit"),
    CART("cart"),
    ACCESS("access"),
    CONFIRM("confirm"), NONE("NONE"), SHOW_RESTAURANTS("showres"), EDIT_LOCATION("editloc"),
    TEST("test"), CHANGE_PASS("change"), CHANGE_ANSWER("answeer"), SELECT_FOOD("sefood");














    private String value;

    Inputs(String value){
        this.value = value;
    }


    public static Inputs getEnum(String first) {
        for (Inputs input: Inputs.values()) {
            if(input.value.equals(first))
                return input;
        }
        return NONE;
    }
}
