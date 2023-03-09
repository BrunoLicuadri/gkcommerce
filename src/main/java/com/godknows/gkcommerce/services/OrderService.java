package com.godknows.gkcommerce.services;

import com.godknows.gkcommerce.dto.OrderDTO;
import com.godknows.gkcommerce.entities.Order;
import com.godknows.gkcommerce.repositories.OrderRepository;
import com.godknows.gkcommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly=true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}