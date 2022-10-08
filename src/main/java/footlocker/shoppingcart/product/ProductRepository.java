package footlocker.shoppingcart.product;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
@Collection("products")
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface ProductRepository extends CouchbaseRepository<Product, String>, DynamicProxyable<ProductRepository> {
}
