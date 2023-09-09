package com.demo.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Abstraction to perform CRUD operations to database
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
