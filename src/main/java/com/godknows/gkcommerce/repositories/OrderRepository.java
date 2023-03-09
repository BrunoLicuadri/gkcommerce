package com.godknows.gkcommerce.repositories;

import com.godknows.gkcommerce.entities.Order;
import com.godknows.gkcommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
