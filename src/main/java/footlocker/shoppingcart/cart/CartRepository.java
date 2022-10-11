package footlocker.shoppingcart.cart;

import footlocker.shoppingcart.product.Product;
import footlocker.shoppingcart.user.User;
import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("cartRepository")
@Collection("cart")
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface CartRepository extends CouchbaseRepository<Cart, String>, DynamicProxyable<CartRepository> {

    public List<Cart> findAllByUserId(String userId);
    public Optional<Cart> findByUserAndProduct(User user, Product product);

    public List<Cart> deleteAllByUserId(String userId);
}
