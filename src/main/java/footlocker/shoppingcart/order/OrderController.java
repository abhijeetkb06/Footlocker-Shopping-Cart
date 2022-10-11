package footlocker.shoppingcart.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/order/{userId}", produces = APPLICATION_JSON_VALUE)
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrder(@PathVariable(value = "userId", required = true) String userId) {
        return orderService.find(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity insertOrder(@PathVariable(value = "userId", required = true) String userId) {
        orderService.insert(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Order placed successfully for user:  " + userId);
    }
}
