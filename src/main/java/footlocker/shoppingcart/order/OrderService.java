package footlocker.shoppingcart.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    // Todo: implement order service

    private OrderRepository orderRepository;

    public OrderService(@Autowired OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    public void somethingCustom() {
//        orderRepository.somethingCustom();
//    }
}
