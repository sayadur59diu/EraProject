package com.example.SpringProductDesigner.service;

import com.example.SpringProductDesigner.entity.ProductDesignerEntity;

import java.util.List;

public interface ProductDesignerService  {
    ProductDesignerEntity saveProductDesigner(ProductDesignerEntity productDesigner);

    List<ProductDesignerEntity> getAllProductDesigns();


    ProductDesignerEntity getProductDesignByBranchAndType(String branchCode, String productTypeCode);

}
