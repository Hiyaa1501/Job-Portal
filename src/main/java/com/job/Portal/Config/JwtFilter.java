package com.job.Portal.Config;

import com.job.Portal.Entity.User;
import com.job.Portal.Repository.UserRepository;
import com.job.Portal.Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component   //creates a jwt filter object
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        //Does this request contain an Authorization header
        String authHeader = request.getHeader("Authorization");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            //Bearer abc123
            //^^^^^^^
            //1234567
            String email = jwtService.extractEmail(token);
            //email extracted form token -> user repo finds the email
            User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
            // actual user info is accessed

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("User email: " + email);
        }

        filterChain.doFilter(request, response);
    }
}
