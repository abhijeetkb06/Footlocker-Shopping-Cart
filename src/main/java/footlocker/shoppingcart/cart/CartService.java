package footlocker.shoppingcart.cart;

import com.couchbase.client.java.kv.CounterResult;
import com.couchbase.client.java.kv.IncrementOptions;
import footlocker.shoppingcart.common.exceptions.NotFoundException;
import footlocker.shoppingcart.product.Product;
import footlocker.shoppingcart.product.ProductService;
import footlocker.shoppingcart.user.User;
import footlocker.shoppingcart.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;
    private UserService userService;
    private ProductService productService;

    @Autowired
    public CartService(CartRepository cartRepository,
                       UserService userService,
                       ProductService productService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.productService = productService;
    }

    public List<Cart> find(String userId) {
        return cartRepository.findAllByUserId(userId);
    }



    public Optional<Cart> find(User user, Product product) {
        return cartRepository.findByUserAndProduct(user, product);
    }

    public Cart insert(String userId, CartDto cartDto) {
        User user = userService.find(userId).orElseThrow(() -> new NotFoundException("Invalid user"));
        Product product = productService.find(cartDto.getSku()).orElseThrow(() -> new NotFoundException(("Invalid product")));
//        this.find(user, product).ifPresent(cart -> { throw new AlreadyExistException("Product already exist"); });
        CounterResult myID = cartRepository.getOperations().getCouchbaseClientFactory().getCollection("cart").binary().increment("NextSequence", IncrementOptions.incrementOptions().initial(1));
        String seqId="cart::"+String.valueOf(myID.content());
        return cartRepository.save(new Cart(seqId,user, product, cartDto.getQuantity(), cartDto.getQuantity() * product.getPrice()));
    }

    public Cart save(String userId, CartDto cartDto) {
        User user = userService.find(userId).orElseThrow(() -> new NotFoundException("Invalid user"));
        Product product = productService.find(cartDto.getSku()).orElseThrow(() -> new NotFoundException(("Invalid product")));

        int quantity = cartDto.getQuantity();
        /*if(quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Illegal product quantity");
        }*/

        return cartRepository.save(
                this.find(user, product)
                        .orElse(new Cart()
                                .setUser(user)
                                .setProduct(product))
                        .setQuantity(quantity)
                        .setAmount(quantity * product.getPrice()));
    }

    public void delete(String userId, String cartId) {
        User user = userService.find(userId).orElseThrow(() -> new NotFoundException("Invalid user"));
        cartRepository.deleteById(cartId);
    }

//    public void delete(String userId) {
//        User user = userService.find(userId).orElseThrow(() -> new NotFoundException("Invalid user"));
//        cartRepository.deleteAllByUserId(userId);
//    }

    // Check the existing one and update the valule
    // This method can be used for PATCH request with some modification
//    public Cart save(String userId, CartDto cartDto) {
//        User user = userService.find(userId).orElseThrow(() -> new NotFoundException("Invalid user"));
//        Product product = productService.find(cartDto.getProductId()).orElseThrow(() -> new NotFoundException(("Invalid product")));
//
//        Optional<Cart> existingCard = this.find(user, product);
//        Cart cart;
//        if(existingCard.isPresent()) {
//            cart = existingCard.get();
//            int newQuantity = cart.getQuantity() + cartDto.getQuantity();
//            if(newQuantity > product.getQuantity()) {
//                throw new IllegalArgumentException("Illegal product quantity");
//            }
//            cart.setQuantity(newQuantity);
//            cart.setAmount(newQuantity * product.getPrice());
//        } else {
//            cart = new Cart(user, product, cartDto.getQuantity(), cartDto.getQuantity() * product.getPrice());
//        }
//        return cartRepository.save(cart);
//    }

}
