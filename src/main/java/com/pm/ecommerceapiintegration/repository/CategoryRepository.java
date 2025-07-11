package com.pm.ecommerceapiintegration.repository;

import com.pm.ecommerceapiintegration.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
