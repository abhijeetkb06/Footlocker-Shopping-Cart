package footlocker.shoppingcart.order;

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
        return orderRepository.save(new Order(user, cartList));
    }
}
