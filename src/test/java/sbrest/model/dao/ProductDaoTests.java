package sbrest.model.dao;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sbrest.model.Product;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ProductDaoTests {

  @Autowired
  private ProductDao productDao;

  @Test
  public void getProducts() {
    List<Product> products = productDao.getProducts();
    assertThat(products.size()).isEqualTo(2);
  }
}
