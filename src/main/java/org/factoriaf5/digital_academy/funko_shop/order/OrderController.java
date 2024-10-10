package org.factoriaf5.digital_academy.funko_shop.order;

import java.security.Principal;

import org.factoriaf5.digital_academy.funko_shop.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api-endpoint}/orders")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<Page<OrderDTO>> getAllOrders(Principal connectedUser,
            @PageableDefault(size = 8, sort = { "createdAt" }) Pageable pageable) {
        Page<OrderDTO> orders = orderService.getAllOrders(pageable);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(Principal connectedUser, @PathVariable Long id) {
        OrderDTO order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> addOrder(Principal connectedUser, @RequestBody Order order) {
        User user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        OrderDTO createdOrder = orderService.addOrder(order, user);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

   @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO order) {
        OrderDTO updatedOrder = orderService.updateOrder(id, order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Page<OrderDTO>> getOrdersByUser(
            Principal connectedUser,
            @PageableDefault(size = 8, sort = { "createdAt" }) Pageable pageable) {
        User user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        Page<OrderDTO> orders = orderService.getOrdersByUser(user, pageable);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
