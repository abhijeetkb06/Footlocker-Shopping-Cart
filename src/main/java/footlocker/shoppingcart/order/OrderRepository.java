package footlocker.shoppingcart.order;

import com.couchbase.client.java.query.QueryScanConsistency;
import footlocker.shoppingcart.cart.Cart;
import footlocker.shoppingcart.product.Product;
import footlocker.shoppingcart.user.User;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;

import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("orderRepository")
@Collection("orders")
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface OrderRepository extends CouchbaseRepository<Order, String>, DynamicProxyable<OrderRepository> {

    public List<Order> findAllByUserId(String userId);
}
