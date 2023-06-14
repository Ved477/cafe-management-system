package com.inn.cafe.dao;

import com.inn.cafe.entity.Product;
import com.inn.cafe.wrapper.ProductWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {
    List<ProductWrapper> getAllProduct();

    @Transactional
    @Modifying
    void updateProductStatus(@Param("status") String status, @Param("id") long id);

    List<ProductWrapper> getProductByCategory(@Param("id") Long id);

    ProductWrapper getProductById(@Param("id") Long id);
}
