package com.godknows.gkcommerce.services;

import com.godknows.gkcommerce.dto.CategoryDTO;
import com.godknows.gkcommerce.dto.ProductDTO;
import com.godknows.gkcommerce.dto.ProductMinDTO;
import com.godknows.gkcommerce.entities.Category;
import com.godknows.gkcommerce.entities.Product;
import com.godknows.gkcommerce.repositories.ProductRepository;

import com.godknows.gkcommerce.services.exceptions.DatabaseException;
import com.godknows.gkcommerce.services.exceptions.ResourceNotFoundException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> result = repository.findById(id);
        Product product = result.orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado"));
        ProductDTO dto = new ProductDTO (product);
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable){
        Page<Product> result = repository.searchByName(name, pageable);
        return result.map(x-> new ProductMinDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update (Long id, ProductDTO dto){
        try{
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso Não Encontrado");
            }
    }

    @Transactional (propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        try{
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Recurso Não Encontrado");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de Integridade Referencial");
        }

    }


    private void copyDtoToEntity (ProductDTO dto, Product entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
        entity.getCategories().clear();
        for(CategoryDTO catDto : dto.getCategories()){
            Category cat = new Category();
            cat.setId(catDto.getId());
            entity.getCategories().add(cat);
        }
    }


}
