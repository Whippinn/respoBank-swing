/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.manager;

import database.DBHelper;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import user.user;

/**
 *
 * @author respect
 */
public class withdrawMoney {
    public void money(user user, double cekilecek) throws SQLException {
        String sql = "update user set money = ? where email = '"+user.getEmail()+"'";
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        double total = user.getMoney() - cekilecek;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, total);
            //statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
            statement.close();
        }
    }
}
