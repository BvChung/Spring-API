package com.demo.demo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

//    Favor dependency injection, need initialization of userService
//    Autowired does this but need to add annotation of @Service for UserService class
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    GET
    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

//    POST
    @PostMapping
    public void registerUser(@RequestBody User user) {
        this.userService.createUser(user);
    }

//    PUT
    @PutMapping
//    public void updateUser(@RequestBody )

//    DELETE
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
    }
}
