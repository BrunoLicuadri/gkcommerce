package com.godknows.gkcommerce.repositories;

import com.godknows.gkcommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
