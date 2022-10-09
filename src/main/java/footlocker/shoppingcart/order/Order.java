package footlocker.shoppingcart.order;

import footlocker.shoppingcart.cart.Cart;
import footlocker.shoppingcart.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.List;

@Document
@TypeAlias("order")
public class Order {

    @Id
    @GeneratedValue(delimiter = "::", strategy = GenerationStrategy.UNIQUE)
    private String id;

    private User user;

    private List<Cart> cartList;

    public Order() {
    }

    public Order(User user, List<Cart> cartList) {
        this.user = user;
        this.cartList = cartList;
    }

    public String getId() {
        return id;
    }

    public Order setId(String id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Cart> getCart() {
        return cartList;
    }

    public Order setCart(List<Cart> cartList) {
        this.cartList = cartList;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", cartList=" + cartList +
                '}';
    }
}
