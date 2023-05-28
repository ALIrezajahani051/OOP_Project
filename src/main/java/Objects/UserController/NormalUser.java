package Objects.UserController;


import Objects.UserPanelController;

public class NormalUser extends User{
    public UserPanelController  Panel = new UserPanelController(this.getId());
}
