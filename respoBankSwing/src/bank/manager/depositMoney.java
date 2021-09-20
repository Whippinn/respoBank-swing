/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.manager;
import user.user;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import database.DBHelper;
/**
 *
 * @author respect
 */
public class depositMoney {
    public void money(user user, double yatirilacak) throws SQLException {
         Connection conn = null;
         PreparedStatement statement = null;
         DBHelper helper = new DBHelper();
         String sql = "update user set money = ? where email = '" + user.getEmail() + "'";
         try {
             conn = helper.getConnection();
             statement = conn.prepareStatement(sql);
             double total = user.getMoney()+yatirilacak;
             statement.setDouble(1, total);
             statement.executeUpdate();
         } catch(SQLException e) {
             helper.showErrorMessage(e);
         } finally {
             conn.close();
             statement.close();
         }
    }

    public void money(user user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
