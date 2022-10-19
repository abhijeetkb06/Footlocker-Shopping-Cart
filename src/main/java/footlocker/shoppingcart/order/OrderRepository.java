package footlocker.shoppingcart.order;

import com.couchbase.client.java.query.QueryScanConsistency;

import org.springframework.data.couchbase.repository.*;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("orderRepository")
@Collection("orders")
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface OrderRepository extends CouchbaseRepository<Order, String>, DynamicProxyable<OrderRepository> {

    public List<Order> findAllByUserId(String userId);
}
