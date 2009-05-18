/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jwitter;

import java.sql.Connection;

public class User {
    private int id;
    private String username;
    private String password;
    private int rank;
    public final static int RANK_USER = 0;
    public final static int RANK_ADMIN = 0;

    public User(String username, String password) {
        this(username, password, User.RANK_USER);
    }

    public User(String username, String password, int rank) {
        this.id = 0;
        this.username = username;
        this.password = password;
        this.rank = rank;
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

    public void save() {
        if(this.id == 0) {
            UserDAO udao = new UserDAO();
            udao.insertUser(this);
        }
    }
}
