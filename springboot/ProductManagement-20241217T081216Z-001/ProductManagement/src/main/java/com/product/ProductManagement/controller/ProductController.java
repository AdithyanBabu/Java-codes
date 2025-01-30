package com.product.ProductManagement.controller;

import com.product.ProductManagement.model.Product;
import com.product.ProductManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller@
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/search")
    public String searchProducts(
            @RequestParam String name,
            Model model
    ) {
        List<Product> products = productService.searchProductsByName(name);
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        if (!product.isValid()) {
            return ResponseEntity.badRequest().body("Price must be greater than zero.");
        }
        productService.saveProduct(product);
        return ResponseEntity.ok("Product added successfully.");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(
            @PathVariable int id,
            Model model
    ) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "products";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(
            @PathVariable int id,
            @ModelAttribute Product product
    ) {
        Product existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            productService.saveProduct(existingProduct);
        }
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}


