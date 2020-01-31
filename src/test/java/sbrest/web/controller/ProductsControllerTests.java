package sbrest.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.hamcrest.Matchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void getProduct() throws Exception {
    this.mockMvc.perform(get("/products/1")).andExpect(status().isOk())
        .andExpect(jsonPath("name").value("A Game of Thrones"));
  }

  @Test
  void getProducts() throws Exception {
    mockMvc.perform(get("/products")).andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(Matchers.greaterThanOrEqualTo(2)))
        .andExpect(jsonPath("$[0].name").value("A Game of Thrones"));
  }
}
