package jwitter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
/**
 *
 * @author cygan0031
 */
public class UserDAO {
    private static Connection connection;

    public UserDAO() {
        try {
            this.connection = DBConnection.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean insertUser(User u) {
        try {
            String s = "INSERT INTO APP.USERS (USERNAME, PASSWORD, RANK) VALUES ('" + u.getUsername() + "', '" + u.getPassword() + "', " + u.getRank() + ")";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(User u) {
        try {
            String s = "DELETE FROM APP.USERS WHERE login = '" + u.getUsername() + "'";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            return false;
        }
    }

    public User findUser(String username) {
        try {
            String s = "SELECT * FROM APP.USERS WHERE username = '" + username + "'";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ArrayList<User> al = new ArrayList<User>();
            ResultSet rs = ps.getResultSet();

            if(rs.next()) {
                User u = new User(rs.getString("username"), rs.getString("password"));
                u.setRank(Integer.parseInt(rs.getString("rank")));
                u.setId(Integer.parseInt(rs.getString("id")));
                return u;
            }

            rs.close();
            ps.close();
            return null;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

        return null;
    }

    public boolean updateUser(User u) {
        return true;
    }
    
    public Collection allUsers() {
        try {
            String s = "SELECT * FROM APP.USERS";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ArrayList<User> al = new ArrayList<User>();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                User u = new User(rs.getString("username"), rs.getString("password"));
                u.setRank(Integer.parseInt(rs.getString("rank")));
                u.setId(Integer.parseInt(rs.getString("id")));
                al.add(u);
            }

            rs.close();
            ps.close();
            return al;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

        return null;
    }
}