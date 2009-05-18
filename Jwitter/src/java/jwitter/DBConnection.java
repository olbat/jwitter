/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jwitter;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {

    private static DataSource getJwitter() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/jwitter");
    }

    public static Connection getConnection() throws NamingException, SQLException, SQLException {
        return getJwitter().getConnection();
    }
}