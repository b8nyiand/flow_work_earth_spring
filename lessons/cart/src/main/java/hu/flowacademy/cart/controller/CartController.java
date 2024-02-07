package hu.flowacademy.cart.controller;

import hu.flowacademy.cart.model.Cart;
import hu.flowacademy.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/findById/{id}")
    public Cart findById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

}
