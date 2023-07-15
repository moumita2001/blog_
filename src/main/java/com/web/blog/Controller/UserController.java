package com.web.blog.Controller;
import com.web.blog.DTO.UserDTO;
import com.web.blog.DTO.LoginDTO;
import com.web.blog.Serice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.web.blog.response.LoginResponse;
@RestController
@CrossOrigin
@RequestMapping("/blog/user")
public class UserController {
@Autowired
private UserService userService;
    @PostMapping(path ="/register")
    public String saveUser(@RequestBody UserDTO userDto)
    {
        String id = userService.addUser(userDto);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
