package structure.dao;

import com.mysql.cj.MysqlConnection;
import structure.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        // truy vấn dữ liệu từ database
        Connection conn = MySQLConnection.openConnection();
        String sql = "SELECT * FROM product";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                // biến đổi từng bản ghi trong bảng thành từng đối tượng trong Java
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MySQLConnection.closeConnection(conn);
        return products;
    }
}
