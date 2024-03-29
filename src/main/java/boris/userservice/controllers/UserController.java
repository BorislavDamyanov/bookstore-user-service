package boris.userservice.controllers;

import boris.userservice.entities.User;
import boris.userservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private IUserService userService;


    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.getUserList();
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable("id")Long id){
        return userService.getUser(id).orElse(null);
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@Valid @RequestBody User user){
        User savedUser = userService.addUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id){
       userService.deleteUserById(id);
    }
}
