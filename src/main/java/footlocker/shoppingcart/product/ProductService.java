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
                new Product("1","Converse All Star High Top - Boys' Preschool", "13.0", "Red", "Converse", false,false,false,"PCLO-01","IL2","1287533","REGULAR","13.0",50.0),
                new Product("2","Converse All Star High Top - Girls' Preschool", "6.0", "Black", "Converse", false,false,false,"PCLO-01","IL2","43534543","REGULAR","6.0",60.0),
                new Product("3","Reebok Men", "7.0", "White", "Reebok", false,false,false,"PCLO-01","IL2","56757785","REGULAR","7.0",80.0),
                new Product("4","Shoes", "9.0", "Green", "Nike", true,false,false,"PCLO-01","IL2","7687876","REGULAR","9.0",60.0),
                new Product("5","Hoodie", "M", "Yellow", "Nike", true,false,false,"PCLO-01","IL2","78978998","REGULAR","M",200.0)
        ));
    }
}
