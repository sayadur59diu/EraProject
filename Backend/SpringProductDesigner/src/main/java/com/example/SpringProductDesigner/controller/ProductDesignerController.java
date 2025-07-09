package com.example.SpringProductDesigner.controller;

import com.example.SpringProductDesigner.entity.ProductDesignerEntity;
import com.example.SpringProductDesigner.service.ProductDesignerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product-designer")
public class ProductDesignerController {

    @Autowired
    private ProductDesignerService productDesignerService;

    // Endpoint to save a product designer entity with success/failure message
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createProductDesign(@Valid @RequestBody ProductDesignerEntity productDesigner) {
        Map<String, Object> response = new HashMap<>();
        try {
            ProductDesignerEntity savedProduct = productDesignerService.saveProductDesigner(productDesigner);
            response.put("message", "Product Designer saved successfully.");
            response.put("status", "success");
            response.put("data", savedProduct);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Failed to save Product Designer: " + e.getMessage());
            response.put("status", "error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ✅ Optional: leave others unchanged or update them similarly
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

    @DeleteMapping("/{branchCode}/{productTypeCode}")
    public ResponseEntity<Map<String, String>> deleteProductDesign(
            @PathVariable String branchCode, @PathVariable String productTypeCode) {
        Map<String, String> response = new HashMap<>();
        try {
            ProductDesignerEntity productDesigner = productDesignerService.getProductDesignByBranchAndType(branchCode, productTypeCode);
            if (productDesigner != null) {
                productDesignerService.deleteProductDesign(productDesigner);
                response.put("message", "Product Designer deleted successfully.");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Product Designer not found.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Failed to delete Product Designer: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateProductDesign(@Valid @RequestBody ProductDesignerEntity productDesigner) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 1. Check if entity exists
            ProductDesignerEntity existing = productDesignerService
                    .getProductDesignByBranchAndType(productDesigner.getBranchCode(), productDesigner.getProductTypeCode());

            if (existing == null) {
                response.put("message", "Product Designer not found for update.");
                response.put("status", "not_found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            // 2. Update only desired fields (not composite keys)
            existing.setFullDescription(productDesigner.getFullDescription());
            existing.setAccountCategory(productDesigner.getAccountCategory());
            existing.setIsMinBalanceCheckRequired(productDesigner.getIsMinBalanceCheckRequired());
            existing.setIsDebitBalanceAllowed(productDesigner.getIsDebitBalanceAllowed());
            existing.setIsOverdraftLimitAllowed(productDesigner.getIsOverdraftLimitAllowed());
            existing.setIsPassbookFacilitiesFlag(productDesigner.getIsPassbookFacilitiesFlag());
            existing.setIsChequebookFacilitiesFlag(productDesigner.getIsChequebookFacilitiesFlag());
            existing.setChequeNumberLength(productDesigner.getChequeNumberLength());
            existing.setIsMinBalanceCheckRequired( productDesigner.getIsMinBalanceCheckRequired());
            existing.setIsOverdraftLimitAllowed(productDesigner.getIsOverdraftLimitAllowed());
            existing.setShortDescription(productDesigner.getShortDescription());
            existing.setInterestRoundingMethod(productDesigner.getInterestRoundingMethod());
            // Add more field updates as needed

            // 3. Save updated entity
            ProductDesignerEntity updatedProduct = productDesignerService.updateProductDesigner(existing);

            // 4. Return response
            response.put("message", "Product Designer updated successfully.");
            response.put("status", "success");
            response.put("data", updatedProduct);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Failed to update Product Designer: " + e.getMessage());
            response.put("status", "error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}