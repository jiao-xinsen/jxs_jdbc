package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class zengshan {
    public static int zs(String sql, Object[] objs) {
        int num = 0;
        Connection connection = huoqu.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 1; i <= objs.length; i++) {
                ps.setObject(i, objs[i-1]);
            }
            num = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (num != 0) {
            huoqu.close(ps, connection, null);
        }
        return num;
    }
}
