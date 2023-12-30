package lk.ijse.semisterfinal.Dao;

import lk.ijse.semisterfinal.DB.DbConnetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlUtil {
    public static <T> T test(String sql, Object... ob) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnetion.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < ob.length; i++){
            pstm.setObject((i+1),ob[i]);
        }

        if (sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();
        } else {
            return (T) (Boolean)(pstm.executeUpdate() > 0);
        }
    }


}
