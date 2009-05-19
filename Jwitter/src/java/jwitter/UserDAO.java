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
            UserDAO.connection.close();
            return true;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                UserDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean followUser(int user_id, int followed_id) {
        try {
            String s = "INSERT INTO APP.FOLLOWERS (USER_ID, FOLLOWER_ID) VALUES (" + followed_id + ", " + user_id + ")";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ps.close();
            UserDAO.connection.close();
            return true;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                UserDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean deleteFollow(int user_id, int followed_id) {
        try {
            String s = "DELETE FROM APP.FOLLOWERS WHERE user_id = " + followed_id + " AND follower_id = " + user_id;
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ps.close();
            UserDAO.connection.close();
            return true;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                UserDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean deleteUser(User u) {
        try {
            String s = "DELETE FROM APP.USERS WHERE id = " + u.getId();
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ps.close();
            UserDAO.connection.close();
            return true;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                UserDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean changeUserGrade(User u, boolean upgrade) {
        try {
            String s = "UPDATE APP.USERS SET rank = " + (upgrade ? User.RANK_ADMIN : User.RANK_USER) + " WHERE id = " + u.getId();
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ps.close();
            UserDAO.connection.close();
            return true;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                UserDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
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
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        try {
            UserDAO.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findUser(int id) {
        try {
            String s = "SELECT * FROM APP.USERS WHERE id = " + id;
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
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        try {
            UserDAO.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Collection getFollowersUsers(int user_id) {
        try {
            String s = "SELECT * FROM APP.USERS, APP.FOLLOWERS WHERE USERS.id = follower_id AND user_id = " + user_id;
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
            UserDAO.connection.close();
            return al;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                UserDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return null;
        }
    }

    public Collection getFollowingUsers(int follower_id) {
        try {
            String s = "SELECT * FROM APP.USERS, APP.FOLLOWERS WHERE USERS.id = user_id AND follower_id = " + follower_id;
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
            UserDAO.connection.close();
            return al;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                UserDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return null;
        }
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
            UserDAO.connection.close();
            return al;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                UserDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return null;
        }
    }
}