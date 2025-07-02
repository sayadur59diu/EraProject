package com.example.SpringProductDesigner.controller;

import com.example.SpringProductDesigner.entity.ProductDesignerEntity;
import com.example.SpringProductDesigner.repository.ProductDesignerRepository;
import com.example.SpringProductDesigner.service.ProductDesignerService;
import jakarta.validation.Valid;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-designer")
public class ProductDesignerController {
    // Injecting the ProductDesignerService to handle business logic
   @Autowired
    private ProductDesignerService productDesignerService;
    // Injecting the ProductDesignerRepository to interact with the database
    @GetMapping
    public ResponseEntity<List<ProductDesignerEntity>> getAllProductDesigns() {
        try {
            List<ProductDesignerEntity> productDesigns = productDesignerService.getAllProductDesigns();
            return ResponseEntity.ok(productDesigns);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{branchCode}/{productTypeCode}")
    public ResponseEntity<ProductDesignerEntity> getProductDesignByBranchAndType(
            @PathVariable String branchCode, @PathVariable String productTypeCode) {
        try {
            ProductDesignerEntity productDesigner = productDesignerService.getProductDesignByBranchAndType(branchCode, productTypeCode);
            if (productDesigner != null) {
                return ResponseEntity.ok(productDesigner);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint to save a product designer entity
   @PostMapping("/save")
    public ResponseEntity<ProductDesignerEntity> createProductDesign(@Valid @RequestBody ProductDesignerEntity productDesigner) {
        try {
            ProductDesignerEntity savedProduct = productDesignerService.saveProductDesigner(productDesigner);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



}
