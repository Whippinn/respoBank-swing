/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import user.user;
import java.sql.SQLException;
/**
 *
 * @author respect
 */
public interface IControl {
    boolean control(user user) throws SQLException;
}
