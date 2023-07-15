package com.web.blog.Serice;

import com.web.blog.DTO.LoginDTO;
import com.web.blog.DTO.UserDTO;
import com.web.blog.model.User;
import com.web.blog.response.LoginResponse;

public interface UserService{
     String addUser(UserDTO userDto) ;

     LoginResponse loginUser(LoginDTO loginDTO);

    //User getUserByUsername(String username);
}
