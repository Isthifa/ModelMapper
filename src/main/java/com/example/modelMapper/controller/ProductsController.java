package com.example.modelMapper.controller;

import com.example.modelMapper.dto.ProductDTO;
import com.example.modelMapper.entity.Products;
import com.example.modelMapper.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    //here we are autowiring the modelMapper bean
    private final ModelMapper modelMapper;

    @GetMapping("/byid/{id}")
    public ProductDTO getProductById(@PathVariable int id){
        Products products=productService.findById(id);
        //here we are mapping the Products object to ProductDTO object using modelMapper
        ProductDTO productDTO=modelMapper.map(products,ProductDTO.class);

        return productDTO;
    }

    @PostMapping("/save")
    public Products saveProduct(@RequestBody Products products){
        return productService.save(products);
    }

    @PutMapping("/update/{id}")
    public Products updateProduct(@RequestBody Products products,@PathVariable int id){
        return productService.update(products,id);
    }

    @GetMapping("/byname/{name}")
    public ProductDTO getProductByName(@PathVariable String name){
         Products products=productService.findByName(name);
         ProductDTO productDTO=modelMapper.map(products,ProductDTO.class);
         return productDTO;
    }

    @GetMapping("/all")
    public List<Products> getAllProducts(){
        return productService.findall();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.delete(id);
        return "Product deleted with id "+id;
    }
}
