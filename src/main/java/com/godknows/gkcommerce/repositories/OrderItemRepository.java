package com.godknows.gkcommerce.repositories;

import com.godknows.gkcommerce.entities.Order;
import com.godknows.gkcommerce.entities.OrderItem;
import com.godknows.gkcommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
