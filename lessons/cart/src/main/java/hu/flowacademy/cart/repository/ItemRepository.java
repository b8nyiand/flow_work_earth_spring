package hu.flowacademy.cart.repository;

import hu.flowacademy.cart.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
