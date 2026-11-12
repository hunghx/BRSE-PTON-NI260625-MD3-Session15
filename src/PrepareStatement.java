import structure.dao.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatement {
    public static void main(String[] args) {
        Connection conn = MySQLConnection.openConnection();
        if (conn !=null){
            System.out.println("Kết nối thành công !!");
        }

        // tạo và thực thi câu lệnh với PreparedStatement
        // SQL chia làm các nhóm khác nhau : DDL, DML(SELECT, INSERT, UPDATE, DELETE), DCL, TCL
//        String sql = """
//                CREATE TABLE product(
//                    id int auto_increment primary key,
//                    name varchar(255)
//                )
//                """;
//        String sql = "INSERT INTO product(name) values ('Laptop'),('Iphone'),('TV')";
        String sql = "DELETE FROM product WHERE id = 2";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            // thực thi câu lệnh
//            statement.execute(); // thực hiện tất cả cấu lệnh SQL và trả về đúng/ sai
//            statement.executeQuery(); // Thực hiện các câu lệnh SELECT
            statement.executeUpdate(); // Thực hiện các câu lệnh Update, Delete, Insert

            // Hãy thực hiện 2 câu lệnh Insert và Delete dữ liệu trong bảng vừa tạo
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MySQLConnection.closeConnection(conn);
    }

    public static void addProduct(String productName){
        Connection conn = MySQLConnection.openConnection();
        if (conn !=null){
            System.out.println("Kết nối thành công !!");
        }
        String sql = "INSERT INTO product(name) values (?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, productName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MySQLConnection.closeConnection(conn);
    }
}
