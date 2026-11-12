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
        String sql = """
                CREATE TABLE product(
                    id int auto_increment primary key,
                    name varchar(255)
                )
                """;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            // thực thi câu lệnh
            statement.execute(); // thực hiện tất cả cấu lệnh SQL và trả về đúng/ sai
//            statement.executeQuery(); // Thực hiện các câu lệnh SELECT
//            statement.executeUpdate(); // Thực hiện các câu lệnh UPdate, Delete, Insert

            // Hãy thực hiện 2 caau lệnh Insert và Delete dữ liệu trong bảng vừa tạo
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MySQLConnection.closeConnection(conn);
    }
}
