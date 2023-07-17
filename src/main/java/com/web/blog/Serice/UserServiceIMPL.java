package com.web.blog.Serice;
import com.web.blog.DTO.LoginDTO;
import com.web.blog.DTO.UserDTO;
import com.web.blog.Repo.UserRepo;
import com.web.blog.model.User;
import com.web.blog.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {



    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getUsername(),
                this.passwordEncoder.encode(userDto.getPassword()),
                userDto.getEmail()

        );
        userRepo.save(user);
        return user.getUserName();


    }
//    @Override
//    public User getUserByUsername(String username) {
//        return userRepo.findByUsername(username);
//    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByUsername(loginDTO.getUsername());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepo.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("username not exits", false);
        }
    }
}
