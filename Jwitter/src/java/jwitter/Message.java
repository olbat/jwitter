/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jwitter;

import java.util.Collection;
import java.util.Date;


public class Message {
    private int id;
    private String content;
    private int user_id;
    private int privacy;
    private int friend_id;
    private Date created;
    private String username;

    public final static int PRIVACY_PUBLIC = 0;
    public final static int PRIVACY_PRIVATE = 1;
    public final static int PRIVACY_DIRECT = 2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public Date getCreated() {
        return created;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return this.id + "";
    }

    public int getPrivacy() {
        return privacy;
    }

    public int getUser_id() {
        return user_id;
    }

    public Message() {
        this.id = 0;
        this.user_id = 0;
        this.privacy = Message.PRIVACY_PUBLIC;
        this.friend_id = 0;
        this.created = new Date();
    }

    public Message(int id) {
        this();
        this.id = id;
    }

    public Message(String content, int user_id, int privacy, int friend_id, Date created) {
        this();
        this.content = content;
        this.user_id = user_id;
        this.privacy = privacy;
        this.friend_id = friend_id;
        this.created = created;
    }

    public boolean save() {
        if(this.id == 0) {
            MessageDAO mdao = new MessageDAO();
            return mdao.insertMessage(this);
        } else {
            return false;
        }
    }

    public static Collection getFromUserPublic(User u) {
        MessageDAO mdao = new MessageDAO();
        return mdao.allMessages("user_id = " + u.getId() + " AND privacy = " + Message.PRIVACY_PUBLIC);
    }

    public static Collection getAllPublic() {
        MessageDAO mdao = new MessageDAO();
        return mdao.allMessages("privacy = " + Message.PRIVACY_PUBLIC);
    }

    public static Collection getFromUserAll(User u) {
        MessageDAO mdao = new MessageDAO();
        return mdao.allMessages("user_id = " + u.getId());
    }

    public static Collection getAll() {
        MessageDAO mdao = new MessageDAO();
        return mdao.allMessages("1 = 1");
    }

    public static Collection getAllForUser(User u) {
        MessageDAO mdao = new MessageDAO();
        return mdao.allMessages("(user_id = " + u.getId() + " OR (friend_id = " + u.getId() + ") OR ((privacy = " + Message.PRIVACY_PUBLIC + " OR privacy = " + Message.PRIVACY_PRIVATE + ") AND user_id IN (SELECT user_id FROM APP.FOLLOWERS WHERE follower_id = " + u.getId() + ")))");
    }

    public boolean delete() {
        MessageDAO mdao = new MessageDAO();
        return mdao.deleteMessage(this);
    }
}
