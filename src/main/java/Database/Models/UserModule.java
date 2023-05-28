package Database.Models;

import Database.Connector;
import Objects.Auth.Hasher;
import Objects.UserController.Admin;
import Objects.UserController.NormalUser;
import Objects.UserController.User;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModule {


    ///

    public static Admin getAdmin(String username) {


        Admin admin  = new Admin();
        Connection connection = Connector.connector.connect();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * from users WHERE username ='" + username + "';").executeQuery();
            System.out.println("AAA");
            if (resultSet.next()){
                admin.setId(resultSet.getInt(1));
                admin.setUsername(resultSet.getString(2));
                admin.setName(resultSet.getString(4));
                admin.setFamily(resultSet.getString(5));
                admin.setPhone(resultSet.getString(6));
                admin.setEmail(resultSet.getString(7));
                admin.setAddress(resultSet.getString(8));
                admin.setStatus(resultSet.getBoolean(9));
                admin.setPosition(resultSet.getString(10));
                admin.setCredit(resultSet.getInt(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        return admin;
    }
//
    public static NormalUser getNormalUser(String username) {
        NormalUser normaluser = new NormalUser();
        Connection connection = Connector.connector.connect();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * from users WHERE username ='" + username + "';").executeQuery();

            if (resultSet.next()){
                normaluser.setId(resultSet.getInt(1));
                normaluser.setUsername(resultSet.getString(2));
                normaluser.setName(resultSet.getString(4));
                normaluser.setFamily(resultSet.getString(5));
                normaluser.setPhone(resultSet.getString(6));
                normaluser.setEmail(resultSet.getString(7));
                normaluser.setAddress(resultSet.getString(8));
                normaluser.setStatus(resultSet.getBoolean(9));
                normaluser.setPosition(resultSet.getString(10));
                normaluser.setCredit(resultSet.getInt(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        return normaluser;
    }

    public static String getPosition(String username) {
        String position = null;
        Connection connection = Connector.connector.connect();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT position from users WHERE username ='" + username + "';").executeQuery();
            if (resultSet.next())
                position = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        return position;
    }





    ///

    public static void updatecredit() {
        Connector.Raw("UPDATE users SET credit = " + User.logger.getCredit() + " WHERE id = " + User.logger.getid() + ";");
    }

    public static boolean checkHasUsername(String username) {
        Connection connection = Connector.connector.connect();
        boolean has = false;
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * from users WHERE username ='" + username + "';").executeQuery();

            if (resultSet.next())
                has = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        return has;
    }

    public static String getPassword(String username) {
        Connection connection = Connector.connector.connect();
        String password = null;
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT password from users WHERE username ='" + username + "';").executeQuery();

            if (resultSet.next())
                password = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        return password;
    }

    public static User getUser(String username){
        Connection connection = Connector.connector.connect();
        User user = new User();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * from users WHERE username ='" + username + "';").executeQuery();

            if (resultSet.next()){
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setName(resultSet.getString(4));
                user.setFamily(resultSet.getString(5));
                user.setPhone(resultSet.getString(6));
                user.setEmail(resultSet.getString(7));
                user.setAddress(resultSet.getString(8));
                user.setStatus(resultSet.getBoolean(9));
                user.setPosition(resultSet.getString(10));
                user.setCredit(resultSet.getInt(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        return user;
    }
    public static User getUser(int id){
        Connection connection = Connector.connector.connect();
        User user = new User();
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * from users WHERE id =" + id + ";").executeQuery();

            if (resultSet.next()){
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setName(resultSet.getString(4));
                user.setFamily(resultSet.getString(5));
                user.setPhone(resultSet.getString(6));
                user.setEmail(resultSet.getString(7));
                user.setAddress(resultSet.getString(8));
                user.setStatus(resultSet.getBoolean(9));
                user.setPosition(resultSet.getString(10));
                user.setCredit(resultSet.getInt(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        return user;
    }


    public static String getAnswer(String username) {
        Connection connection = Connector.connector.connect();
        String answer = null;
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT security_question from users WHERE username ='" + username + "';").executeQuery();

            if (resultSet.next())
                answer = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        return answer;
    }

    public static void changePass(String newpass) throws NoSuchAlgorithmException {
        String passwordhashed = Hasher.getHasher(newpass);
        Connector.Raw("UPDATE users SET password = '" + newpass + "' WHERE id = " + User.logger.getid() + ";");
    }

    public static void changePass(String username,String newpass) throws NoSuchAlgorithmException {
        String passwordhashed = Hasher.getHasher(newpass);
        Connector.Raw("UPDATE users SET password = '" + newpass + "' WHERE username = '" + username + "';");
    }

    public static boolean checkHasAddress(){
        Connection connection = Connector.connector.connect();
        String answer = null;
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT address from users WHERE id ='" + User.logger.getid() + "';").executeQuery();

            if (resultSet.next())
                answer = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        if(answer != null && !answer.equals(""))
            return true;
        return false;
    }

    public static void singup(String name, String family, String username, String password,String security_answer,String position) {
        Connector.Raw("INSERT INTO users (username,password,name,family,position,security_question) VALUES ('"+ username  + "','" + password +"','" + name +"','" + family + "','" + position + "','" + security_answer + "');");
    }

    public static String getLastPK() {
        Connection connection = Connector.connector.connect();
        String pk = null;
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT * FROM pk_orders WHERE user = "+ NormalUser.logger.getid() + "AND status = 0;\n").executeQuery();

            if (resultSet.next())
                pk = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        return pk;
    }

    public static boolean checkHasAnswer(String username) {
        Connection connection = Connector.connector.connect();
        String answer = null;
        try {
            ResultSet resultSet;
            resultSet = connection.prepareStatement("SELECT security_question from users WHERE username ='" + username + "';").executeQuery();

            if (resultSet.next())
                answer = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connector.connector.disconnect();
        }

        if(answer != null && !answer.equals(""))
            return true;
        return false;
    }

}
