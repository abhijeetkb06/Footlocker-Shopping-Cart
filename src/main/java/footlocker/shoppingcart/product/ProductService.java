package footlocker.shoppingcart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> find(String id) {
        return productRepository.findById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public void insertProductSampleData() {
        productRepository.saveAll(Arrays.asList(
                new Product("Apple IPhone 7", "apple-iphone5.jpg", "Apple IPhone 5 128GB", 1050.00, 5),
                new Product("Apple IPhone 8", "apple-iphone8.jpg", "Apple IPhone 8 128GB", 1250.00, 10),
                new Product("Samsung S9", "samsung-s9.jpg", "samsung S9 64GB", 900.00, 2),
                new Product("Samsung S10", "samsung-s10.jpg", "Samsung S9 128GB", 1000.00, 15),
                new Product("One plus one", "one-plus-one.jpg", "One plus one 128GB", 750.00, 3)
        ));
    }
}
