package com.utfpr.APIWeb2.infra.security;

import com.utfpr.APIWeb2.infra.persistence.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter{
    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

            if (!request.getRequestURI().startsWith("/auth/login")) {

                if (token != null) {
                    try {
                        // Valida o token
                        var login = tokenService.validateToken(token);
                        UserDetails user = userRepository.findByEmail(login);

                        if (user == null) {
                            throw new Exception("User not found: " + login);
                        }

                        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    } catch (Exception e) {
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        response.getWriter().write("An error occurred during token validation: " + e.getMessage());
                        return;
                    }
                } else {
                    System.out.println("No token found in the request");
                }
            }

        filterChain.doFilter(request, response);
    }

    //Pega o token que vem do Authorization e verifica se é nulo, se não for retorna apenas o token
   private String recoverToken(HttpServletRequest httpServletRequest){
        var authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader == null){
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }

}
