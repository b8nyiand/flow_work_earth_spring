package hu.flowacademy.cart.service;

import hu.flowacademy.cart.model.Cart;
import hu.flowacademy.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart getCartById(Long id) {
        Optional<Cart> cartOpt = cartRepository.findById(id);
        return cartOpt.orElse(null);
    }

}
