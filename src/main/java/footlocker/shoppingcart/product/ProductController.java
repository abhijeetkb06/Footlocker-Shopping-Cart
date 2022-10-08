package footlocker.shoppingcart.product;

import footlocker.shoppingcart.common.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/product", produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private ProductService productService;

    public ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping(value = "{id}")
    public Product getProduct(@PathVariable("id") String id) {
        return productService.find(id).orElseThrow(() -> new NotFoundException(String.format("Not found: %s", id)));
    }
}
