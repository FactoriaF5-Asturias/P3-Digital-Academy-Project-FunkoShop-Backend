package org.factoriaf5.digital_academy.funko_shop.order;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.factoriaf5.digital_academy.funko_shop.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByUser(User user, Pageable pageable);
}
