package sbrest.model.dao;

import java.util.List;

import sbrest.model.Product;

public interface ProductDao {

  Product getProduct(Integer id);

  List<Product> getProducts();

  Product saveProduct(Product product);
}
