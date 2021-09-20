/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import user.user;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import database.DBHelper;
/**
 *
 * @author respect
 */
public class login implements IControl{
    public boolean control(user user) throws SQLException {
        String sql = "select email,password from user";
        Connection conn = null;
        DBHelper helper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            conn = helper.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                if(user.getEmail().equals(resultSet.getString("email")) && user.getPassword().equals(resultSet.getString("password"))) {
                    return true;
                }
            }
        } catch(SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            conn.close();
            statement.close();
        }
        return false;
    }
}
