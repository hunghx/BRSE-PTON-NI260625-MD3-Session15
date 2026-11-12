import structure.dao.MySQLConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class CallableStatement {
    public static void addProduct(String productName){
        Connection conn = MySQLConnection.openConnection();
        if (conn !=null){
            System.out.println("Kết nối thành công !!");
        }
        String sql = "{call proc_insert_product(?)}";
        try {
            java.sql.CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1, productName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MySQLConnection.closeConnection(conn);
    }
}
