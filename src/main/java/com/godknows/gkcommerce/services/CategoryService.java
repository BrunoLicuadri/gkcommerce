package com.godknows.gkcommerce.services;

import com.godknows.gkcommerce.dto.CategoryDTO;
import com.godknows.gkcommerce.dto.ProductDTO;
import com.godknows.gkcommerce.dto.ProductMinDTO;
import com.godknows.gkcommerce.entities.Category;
import com.godknows.gkcommerce.entities.Product;
import com.godknows.gkcommerce.repositories.CategoryRepository;
import com.godknows.gkcommerce.repositories.ProductRepository;
import com.godknows.gkcommerce.services.exceptions.DatabaseException;
import com.godknows.gkcommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> result = repository.findAll();
        return result.stream().map(x-> new CategoryDTO(x)).toList();
    }
}
