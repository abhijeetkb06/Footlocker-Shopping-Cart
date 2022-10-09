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
                new Product("1","Converse All Star High Top - Boys' Preschool", "shoes1.jpg", "Converse", 40.00, 2),
                new Product("2","Mens Nike Hoodie", "Hoodie1.jpg", "Nike", 250.00, 1),
                new Product("3","LCKR Pullover Hoodie", "Hoodie2.jpg", "Nike", 90.00, 2),
                new Product("4","Timberland Boots Women", "shoes2.jpg", "Timberland", 300.00, 3),
                new Product("5","Timberland Boots Men", "shoes3.jpg", "Timberland", 150.00, 3)
        ));
    }
}
