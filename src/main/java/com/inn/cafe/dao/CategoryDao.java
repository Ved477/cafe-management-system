package com.inn.cafe.dao;

import com.inn.cafe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Long> {

    List<Category> getAllCategory();
}
