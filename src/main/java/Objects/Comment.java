package Objects;

public class Comment {

    private String comment;
    private int food_id;

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    private int res_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    private String user_id;

    public void setReply(int reply) {
        this.reply = reply;
    }

    public int getReply() {
        return reply;
    }

    private int reply;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private int id;


    public String getComment() {
        return comment;
    }

    public int getFood_id() {
        return food_id;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }


}
