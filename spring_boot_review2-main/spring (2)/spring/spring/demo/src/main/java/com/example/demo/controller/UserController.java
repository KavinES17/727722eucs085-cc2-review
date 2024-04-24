package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@SuppressWarnings("unused")
@RestController
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<User> postMethodName(@RequestBody User user) {
        if(userService.post(user)==true)
        {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/user/page/{offset}/{pageSize}")
    public ResponseEntity<List<User>> pagination(@PathVariable int offset,@PathVariable int pageSize){
        List<User> page=userService.page(offset, pageSize);
        return new ResponseEntity<>(page,HttpStatus.OK);
    }
@GetMapping("/user/sortBy/{field}")
    public List<User> sortByRate(@PathVariable("field") String field) {
        return userService.sort(field);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getMethodName() {
        List<User> k = userService.getAll();
        return new ResponseEntity<>(k,HttpStatus.OK);
    }
}