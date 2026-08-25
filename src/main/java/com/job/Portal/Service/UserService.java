package com.job.Portal.Service;

import com.job.Portal.Dto.LoginRequestDto;
import com.job.Portal.Dto.LoginResponseDto;
import com.job.Portal.Dto.UserDto;
import com.job.Portal.Dto.UserResponseDto;
import com.job.Portal.Entity.User;
import com.job.Portal.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserResponseDto createUser(UserDto userDto) {

        if(userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email is already registered");
        }

        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());

        User savedUser = userRepository.save(user);
        UserResponseDto response = new UserResponseDto();

        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        //user response doesn't contain a password
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());

        return response;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid enail or password");
        }

        //JWT -> password correct then token will generate
        String token = jwtService.generateToken(user.getEmail());

        LoginResponseDto response = new LoginResponseDto();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());

        return response;
    }
}
