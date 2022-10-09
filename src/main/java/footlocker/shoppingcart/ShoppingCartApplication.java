package footlocker.shoppingcart;

import footlocker.shoppingcart.product.ProductService;
import footlocker.shoppingcart.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ShoppingCartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ShoppingCartApplication.class, args);

		// Insert sample product dataset
		ProductService productService = applicationContext.getBean(ProductService.class);
		productService.deleteAll();
		productService.insertProductSampleData();

		// Insert sample user dataset
		UserService userService = applicationContext.getBean(UserService.class);
		userService.deleteAll();
		userService.insertUserSampleData();
	}

}
