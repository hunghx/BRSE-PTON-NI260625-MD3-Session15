import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL= "jdbc:mysql://localhost:3306/user-service";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456$";


    public static Connection openConnection(){
        // khai báo Driver của MYSQL
        try {
            Class.forName(DRIVER);
            // mơ 1 kết nối
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối không thành công !!");
            e.printStackTrace();
        }
        return null;
    }
    public static void closeConnection(Connection conn){
        if (conn != null){
            try {
                conn.close();
                System.out.println("Đóng kết nối thành công");
            } catch (SQLException e) {
                System.err.println("Lỗi đóng kết nối");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = openConnection();
        if (conn !=null){
            System.out.println("Kết nối thành công !!");
        }
        closeConnection(conn);
    }
}
