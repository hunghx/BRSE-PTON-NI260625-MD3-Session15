package structure.bussiness;

import structure.dao.ProductDao;
import structure.dao.ProductDaoImpl;
import structure.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public void showListProducts() {
        System.out.println("Hiển thị danh sách sản phẩm");
        List<Product> products = productDao.getAllProducts();
        if (products.isEmpty()) {
            System.err.println("Chưa có sản phẩm nào trong DB !");
            return;
        }

        for (Product product: products){
            System.out.println("ID : "+ product.getId()+ " | Name : "+ product.getName());
        }
    }
}
