package com.web.blog.Serice;

import com.web.blog.DTO.LoginDTO;
import com.web.blog.DTO.UserDTO;
import com.web.blog.response.LoginResponse;

public interface UserService{
     Long addUser(UserDTO userDto) ;

     LoginResponse loginUser(LoginDTO loginDTO);

    //User getUserByUsername(String username);
}
