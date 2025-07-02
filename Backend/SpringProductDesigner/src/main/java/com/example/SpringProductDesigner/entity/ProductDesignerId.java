package com.example.SpringProductDesigner.entity;


import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductDesignerId implements Serializable {
    private String branchCode;
    private String productTypeCode;

    public ProductDesignerId() {
        // Default constructor for JPA
    }
    public ProductDesignerId(String branchCode, String productTypeCode) {
        this.branchCode = branchCode;
        this.productTypeCode = productTypeCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDesignerId that)) return false;
        return Objects.equals(branchCode, that.branchCode)
                && Objects.equals(productTypeCode, that.productTypeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchCode, productTypeCode);
    }
}

