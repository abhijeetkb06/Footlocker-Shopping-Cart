package footlocker.shoppingcart.order;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;

import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.stereotype.Repository;

@Repository("orderRepository")
@Collection("orders")
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface OrderRepository extends CouchbaseRepository<Order, String>, DynamicProxyable<OrderRepository> {
}
