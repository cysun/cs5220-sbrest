package sbrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sbrest.model.Product;
import sbrest.model.dao.ProductDao;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/products")
    public List<Product> products(ModelMap models) {
        return productDao.getProducts();
    }
}