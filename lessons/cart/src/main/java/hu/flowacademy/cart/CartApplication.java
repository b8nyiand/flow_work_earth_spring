package hu.flowacademy.cart;

import hu.flowacademy.cart.model.Cart;
import hu.flowacademy.cart.model.Item;
import hu.flowacademy.cart.repository.CartRepository;
import hu.flowacademy.cart.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CartApplication {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			if (cartRepository.findAll().isEmpty()) {
				Cart cart = new Cart("kosar", LocalDate.now());
				cartRepository.save(cart);

				Item item = new Item("hajszarito", 2, 15000, cart);
				Item item2 = new Item("nyomtatopapir", 1, 4000, cart);

				itemRepository.save(item);
				itemRepository.save(item2);
			}
		};
	}
}
