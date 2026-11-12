package structure.dao;

import structure.model.Product;

import java.util.List;


public interface ProductDao {
    List<Product> getAllProducts();
}
