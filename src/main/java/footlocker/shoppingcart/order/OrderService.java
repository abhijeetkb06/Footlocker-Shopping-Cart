package footlocker.shoppingcart.order;

import com.couchbase.client.java.json.JsonArray;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.kv.CounterResult;
import com.couchbase.client.java.kv.IncrementOptions;
import com.couchbase.client.java.query.QueryOptions;
import footlocker.shoppingcart.cart.Cart;
import footlocker.shoppingcart.cart.CartDto;
import footlocker.shoppingcart.cart.CartRepository;
import footlocker.shoppingcart.cart.CartService;
import footlocker.shoppingcart.common.exceptions.NotFoundException;
import footlocker.shoppingcart.product.Product;
import footlocker.shoppingcart.product.ProductService;
import footlocker.shoppingcart.user.User;
import footlocker.shoppingcart.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private UserService userService;

    private CartService cartService;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                       UserService userService,
                        CartService cartService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.cartService=cartService;
    }

    public List<Order> find(String userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public Order insert(String userId) {
        User user = userService.find(userId).orElseThrow(() -> new NotFoundException("Invalid user"));
        List<Cart> cartList = cartService.find(userId);
        CounterResult myID = orderRepository.getOperations().getCouchbaseClientFactory().getCollection("orders")
                .binary().increment("NextSequence", IncrementOptions.incrementOptions().initial(123456));
        String seqId="order::"+String.valueOf(myID.content());
        Order order=orderRepository.save(new Order(seqId, user, cartList));
        cartList.stream().forEach(cart -> cartService.delete(userId,cart.getId()));
        return order;
    }
}
