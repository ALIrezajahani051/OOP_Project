package Objects.UserController;

import Database.Models.UserModule;
import Objects.Order;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    private String name,family,username,address,phone,email,position;
    private int credit = 1000;
    private boolean status;

    private int id;

    private ArrayList<Order> cart = new ArrayList<>();

    public static User logger = null;


    public static boolean isLogger(){
        if (User.logger == null)
            return false;
        return true;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setLogger(User logger) {
        User.logger = logger;
    }

    public int getId() {
        return id;
    }

    public static User getLogger() {
        return logger;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void addCredit(int credit) {
        this.credit += credit;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public int getCredit() {
        return credit;
    }

    public int getid() {
        return id;
    }


    public void changePassword(String newpass) throws NoSuchAlgorithmException {
        UserModule.changePass(newpass);
    }

    public ArrayList<Order> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Order> cart) {
        this.cart = cart;
    }

    public void addToCart(Order order){
        cart.add(order);
    }

    public void deleteFromCart(Order order){
        cart.remove(order);
    }

    public void clearCart(){
        cart = new ArrayList<>();
    }


}
