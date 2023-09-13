package com.demo.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Layer to perform CRUD operations to database
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    Similar to sql but uses entities (Class objects)
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

}
