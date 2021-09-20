/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.manager;
import java.sql.Statement;
import database.DBHelper;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import user.user;
/**
 *
 * @author respect
 */
public class accInfo {
    public void info(user user) throws SQLException {
        String sql = "select firstName,lastName,age,money,phoneNumber,email from user";
        DBHelper helper = new DBHelper();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet;
        try {
            conn = helper.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                if(user.getEmail().equals(resultSet.getString("email"))) {
                    user.setFirstName(resultSet.getString("firstName"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setAge(resultSet.getInt("age"));
                    user.setMoney(resultSet.getDouble("money"));
                    user.setPhoneNumber(resultSet.getString("phoneNumber"));
                    return;
                }
            }
        } catch(SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            conn.close();
            statement.close();
        }
    }
}
