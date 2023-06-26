package com.example.modelMapper.service;

import com.example.modelMapper.entity.Products;

import java.util.List;

public interface ProductService {
    Products save(Products products);

    Products findByName(String name);

    Products update(Products products,int id);

    Products findById(int id);

    List<Products> findall();

    String delete(int id);
}
