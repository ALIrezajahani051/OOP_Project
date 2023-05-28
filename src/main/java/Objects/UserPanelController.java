package Objects;

import Database.Models.CommentModule;
import Database.Models.UserModule;
import Objects.UserController.User;

public class UserPanelController {

    private User normaluser;
    private OrderController OrderPanel = new OrderController(normaluser);
    private RateController RatePanel = new RateController(normaluser);

    public UserPanelController(int user_id){
        normaluser = UserModule.getUser(user_id);
    }

    public void addcredit(int credit){
        User.logger.addCredit(credit);
        UserModule.updatecredit();
    }

    public int getcredit(){
        return this.normaluser.getCredit();
    }


    public void addcommentforrestaurant(String commenttext){
        Comment comment = new Comment();
        comment.setComment(commenttext);
        comment.setUser_id(this.normaluser.getUsername());
        comment.setRes_id(Restaurant.inrestaurant.getId());
        CommentModule.addcommentforrestaurant(commenttext);
        Restaurant.inrestaurant.addComment(comment);
    }

    public void editcommentforrestaurant(String newcomment,int id){
        CommentModule.editcommentforrestaurant(newcomment,id);
        Restaurant.inrestaurant.getComment(id).setComment(newcomment);
    }


    public void addcommentforfood(String commenttext){
        Comment comment = new Comment();
        comment.setComment(commenttext);
        comment.setUser_id(this.normaluser.getUsername());
        comment.setFood_id(Food.infood.getId());
        CommentModule.addcommentforrestaurant(commenttext);
        Food.infood.addComment(comment);
    }

    public void editcommentforfood(String newcomment,int id){
        CommentModule.editcommentforrestaurant(newcomment,id);
        Food.infood.getComment(id).setComment(newcomment);
    }



}
