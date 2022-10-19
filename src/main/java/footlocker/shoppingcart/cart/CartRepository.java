package footlocker.shoppingcart.cart;

import footlocker.shoppingcart.product.Product;
import footlocker.shoppingcart.user.User;
import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("cartRepository")
@Collection("cart")
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface CartRepository extends CouchbaseRepository<Cart, String>, DynamicProxyable<CartRepository> {

    public List<Cart> findAllByUserId(String userId);
    public Optional<Cart> findByUserAndProduct(User user, Product product);

    @Query("#{#n1ql.selectEntity} where `user`.email = $email")
    public List<Cart> findAllByEmailId(String email);

    @Query("#{#n1ql.delete} where `user`.id = $userId")
    public void deleteCartItemsByUserId(String userId);
}
