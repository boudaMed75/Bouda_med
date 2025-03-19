package bouda.med.company.config;

import java.io.IOException;


import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.token.Token;
import bouda.med.company.user.TokenDao;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class JwrAuthenticationFilter extends OncePerRequestFilter{
   

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenDao tokenDao;

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @Nonnull FilterChain filterChain
        )
    throws ServletException, IOException {

        if(request.getServletPath().contains("/api/v1/auth")){
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");
        final String jwt ;
        final String userName ;

        if(authHeader == null || !authHeader.startsWith("Bearer")){
            System.err.println("err");
            filterChain.doFilter(request, response);
            return;
        }

        System.err.println("ok braarer exist");

        jwt = authHeader.substring(7);
        userName = jwtService.extractUsername(jwt);

        System.err.println(userName);
        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
            Boolean isTokenValid = tokenDao.findByToken(jwt)
                .map(t -> !t.isExpired() && !t.isRevoked())
                .orElse(false);
            Token token = tokenDao.findByToken(jwt).orElseThrow(()->new EntityNotFoundException("aucun ele"));

            System.out.println(token.expired);
            System.out.println(token.revoked);
            System.out.println(isTokenValid);
            System.out.println(userDetails.getAuthorities());
            
            if(jwtService.isTokenValid(jwt, userDetails) && isTokenValid){
                System.out.println("ok");
                UsernamePasswordAuthenticationToken auToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
                );

                auToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(auToken);
            }

        }

        filterChain.doFilter(request, response);
    }
    
    
}
