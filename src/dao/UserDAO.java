package dao;

import config.DatabaseConnection;
import model.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
//// pr nous en testant, otherwise il faudrait faire un frame de login??
    public void insertUser(  String fName,String lName,String phone,String address, String email,String psw) {
        LocalDateTime today = LocalDateTime.now();
        String query = "INSERT INTO user (fName,lName, phone, address,  email, psw, today ) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.executeUpdate();
            System.out.println("INSCRIPTION DONE");
        } catch (SQLException e) {
            System.out.println("ERREUR INSCRIPTION : " + e.getMessage());
        }
    }
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fName");
                String lname = rs.getString("lName");
                String phone = rs.getString("fName");
                String address = rs.getString("lName");
                String email = rs.getString("fName");
                String psw = rs.getString("lName");

                Timestamp ts = rs.getTimestamp("signupDate"); // wtf was that guys pdv
                LocalDateTime signupDate = (ts != null) ? ts.toLocalDateTime() : null;


                users.add(new User(id, fname, lname, phone, address, email, psw, signupDate));
            }
        } catch (SQLException e) {
            System.out.println("erreur get : " + e.getMessage());
        }
        return users;
    }

}