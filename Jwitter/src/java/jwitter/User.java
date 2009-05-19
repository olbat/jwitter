/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jwitter;

import java.sql.Connection;
import java.util.Collection;

public class User {
    private int id;
    private String username;
    private String password;
    private int rank;
    public final static int RANK_USER = 0;
    public final static int RANK_ADMIN = 1;

    public String rankToString() {
        return this.isAdmin() ? "admin" : "user";
    }

    public boolean isAdmin() {
        return this.rank == User.RANK_ADMIN;
    }

    public boolean isUser() {
        return this.rank == User.RANK_USER;
    }

    public User(int id) {
        this.id = id;
        this.rank = User.RANK_USER;
    }

    public User(String username, String password) {
        this(username, password, User.RANK_USER);
    }

    public User(String username, String password, int rank) {
        this(0);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getId() {
        return this.id + "";
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean populate() {
        UserDAO udao = new UserDAO();
        User u;
        if(this.id == 0) {
            u = udao.findUser(this.username);
        } else {
            u = udao.findUser(this.id);
        }
            
        
        if(u != null) {
            this.id = u.id;
            this.username = u.username;
            this.password = u.password;
            this.rank = u.rank;
        }
        return u != null;
    }

    public boolean upgrade() {
        UserDAO udao = new UserDAO();
        return udao.changeUserGrade(this, true);
    }

    public boolean downgrade() {
        UserDAO udao = new UserDAO();
        return udao.changeUserGrade(this, false);
    }

    public boolean delete() {
        UserDAO udao = new UserDAO();
        return udao.deleteUser(this);
    }

    public boolean save() {
        if(this.id == 0) {
            UserDAO udao = new UserDAO();
            return udao.insertUser(this);
        } else {
            return false;
        }
    }

    public static Collection getAll() {
        UserDAO udao = new UserDAO();
        return udao.allUsers();
    }
}
