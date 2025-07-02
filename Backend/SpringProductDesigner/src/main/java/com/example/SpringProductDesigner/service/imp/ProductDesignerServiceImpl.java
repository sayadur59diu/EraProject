package com.example.SpringProductDesigner.service.imp;

import com.example.SpringProductDesigner.entity.ProductDesignerEntity;
import com.example.SpringProductDesigner.entity.ProductDesignerId;
import com.example.SpringProductDesigner.repository.ProductDesignerRepository;
import com.example.SpringProductDesigner.service.ProductDesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDesignerServiceImpl implements ProductDesignerService {

    @Autowired
    private ProductDesignerRepository   repository;
    // Implement the methods defined in ProductDesignerService interface
    // For example, you can implement a method to save a product designer entity
    // and handle any business logic related to product design.

    @Override
    public ProductDesignerEntity saveProductDesigner(ProductDesignerEntity productDesigner) {
        // Logic to save the product designer entity
        if (productDesigner.getBranchCode() == null || productDesigner.getProductTypeCode() == null) {
            throw new IllegalArgumentException("Branch code and product type code must not be null");
        }
        if (repository.existsByBranchCodeAndProductTypeCode(productDesigner.getBranchCode(), productDesigner.getProductTypeCode())) {

            throw new IllegalArgumentException("Product designer with this branch code and product type code already exists");

        }
        return repository.save(productDesigner);

    }

    @Override
    public List<ProductDesignerEntity> getAllProductDesigns() {
        return repository.findAll();
    }



    @Override
    public ProductDesignerEntity getProductDesignByBranchAndType(String branchCode, String productTypeCode) {
        ProductDesignerId id = new ProductDesignerId(branchCode, productTypeCode);
        //return repository.findById(Id).orElse(null); // ← Pass the object, not a String
        return repository.findById(id).orElse(null); // Use the correct ID type
    }

}
