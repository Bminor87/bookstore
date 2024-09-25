package com.hellmanstudios.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import com.hellmanstudios.bookstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
