package com.job.Portal.Service;

import com.job.Portal.Dto.UserDto;
import com.job.Portal.Entity.User;
import com.job.Portal.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {

        if(userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email is already registered");
        }

        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        User savedUser = userRepository.save(user);
        UserDto response = new UserDto();

        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setRole(savedUser.getRole());

        return response;
    }
}
