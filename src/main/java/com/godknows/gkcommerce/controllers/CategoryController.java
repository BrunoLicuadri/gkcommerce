package com.godknows.gkcommerce.controllers;

import com.godknows.gkcommerce.dto.CategoryDTO;
import com.godknows.gkcommerce.dto.ProductDTO;
import com.godknows.gkcommerce.dto.ProductMinDTO;
import com.godknows.gkcommerce.services.CategoryService;
import com.godknows.gkcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value="/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

}
