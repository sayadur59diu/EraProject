package com.example.SpringProductDesigner.repository;

import com.example.SpringProductDesigner.entity.ProductDesignerEntity;
import com.example.SpringProductDesigner.entity.ProductDesignerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDesignerRepository extends JpaRepository<ProductDesignerEntity, ProductDesignerId>{
boolean existsByBranchCodeAndProductTypeCode(String branchCode, String productTypeCode);



    }
