package footlocker.shoppingcart.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.Date;
import java.util.Objects;

@Document
@TypeAlias("product")
public class Product {

    @Id @GeneratedValue( delimiter = "::", strategy = GenerationStrategy.UNIQUE)
    private String id;
    private String name;
    private String imageUrl;
    private String info;
    private Double price;
    private Integer quantity;

    public Product(String name, String imageUrl, String info, Double price, Integer quantity) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.info = info;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
