package com.etl.ftp2mysql.external.mapper;

import com.etl.ftp2mysql.external.dto.ProductRequest;
import com.etl.ftp2mysql.external.entity.Product;

public class ProductMapper {
    public Product toEntity(ProductRequest request){
        Product product=new Product();
        product.setProductName(request.getProductName());
        product.setProductCategory(request.getProductCategory());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setPurchasedAt(request.getPurchasedAt());
        return product;
    }

}
