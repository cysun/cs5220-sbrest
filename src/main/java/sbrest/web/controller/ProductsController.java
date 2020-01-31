package sbrest.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import sbrest.model.Product;
import sbrest.model.dao.ProductDao;

@RestController
@RequestMapping("/products")
public class ProductsController {

  @Autowired
  private ProductDao productDao;

  @GetMapping
  public List<Product> list(ModelMap models) {
    return productDao.getProducts();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Integer add(@RequestBody Product product) {
    product = productDao.saveProduct(product);
    return product.getId();
  }

  @GetMapping("/{id}")
  public Product get(@PathVariable Integer id) {
    Product product = productDao.getProduct(id);
    if (product == null)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
    return product;
  }

  @PutMapping("/{id}")
  public void update1(@PathVariable Integer id, @RequestBody Product product) {
    product.setId(id);
    product = productDao.saveProduct(product);
  }

  @PatchMapping("/{id}")
  public void update2(@PathVariable Integer id, @RequestBody Map<String, Object> update) {
    Product product = productDao.getProduct(id);
    for (String key : update.keySet()) {
      switch (key) {
        case "name":
          product.setName((String) update.get(key));
          break;
        case "quantity":
          product.setQuantity((Integer) update.get(key));
          break;
        case "price":
          product.setPrice((Double) update.get(key));
          break;
        default:
      }
    }
    productDao.saveProduct(product);
  }
}
