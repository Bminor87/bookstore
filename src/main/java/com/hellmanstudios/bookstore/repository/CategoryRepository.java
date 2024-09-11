package com.hellmanstudios.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import com.hellmanstudios.bookstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
