package jwitter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

public class MessageDAO {
    private static Connection connection;

    public MessageDAO() {
        try {
            MessageDAO.connection = DBConnection.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean insertMessage(Message m) {
        try {
            String s = "INSERT INTO APP.MESSAGES (CONTENT, USER_ID, PRIVACY, FRIEND_ID, CREATED) VALUES ('" + m.getContent().replace("'", "''") + "', " + m.getUser_id() + ", " + m.getPrivacy() + ", " + m.getFriend_id() + ", '" + (new Timestamp(m.getCreated().getTime())) + "')";
            System.out.println(s);
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ps.close();
            MessageDAO.connection.close();
            return true;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                MessageDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean deleteMessage(Message m) {
        try {
            String s = "DELETE FROM APP.MESSAGES WHERE id = " + m.getId();
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ps.close();
            MessageDAO.connection.close();
            return true;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                MessageDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public Collection allMessages(String conditions) {
        try {
            String s = "SELECT MESSAGES.*, USERS.USERNAME FROM APP.MESSAGES, APP.USERS WHERE MESSAGES.USER_ID = USERS.ID AND " + conditions + " ORDER BY MESSAGES.ID DESC";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.execute();
            ArrayList<Message> al = new ArrayList<Message>();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                
                Date d = null;
                try {
                    d = sdf.parse(rs.getString("created"));
                } catch (ParseException ex) {
                    Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                Message m = new Message(rs.getString("content"), Integer.parseInt(rs.getString("user_id")), Integer.parseInt(rs.getString("privacy")), Integer.parseInt(rs.getString("friend_id")), d);
                m.setUsername(rs.getString("username"));
                m.setId(Integer.parseInt(rs.getString("id")));
                al.add(m);
            }

            rs.close();
            ps.close();
            MessageDAO.connection.close();
            return al;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
            try {
                MessageDAO.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return null;
        }
    }
}