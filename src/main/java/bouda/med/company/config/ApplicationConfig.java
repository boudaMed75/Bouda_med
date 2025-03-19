package bouda.med.company.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import bouda.med.company.auditing.ApplicationAuditAware;
import bouda.med.company.shared.CodeGenerator;
import bouda.med.company.user.UserDao;
import jakarta.servlet.MultipartConfigElement;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor

public class ApplicationConfig {

    private final UserDao userDao;


    @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
      }

    };
  }

    @Bean
    public UserDetailsService userDetailsService(){

        return username -> userDao.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found")) ;

    }

    @Bean
    public AuditorAware<Object> auditorAware(){
        return new ApplicationAuditAware();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

     @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CodeGenerator codeGenerator(){
        return new CodeGenerator();

    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        long maxFileSize = 500 * 1024 * 1024; // 500 MB en octets
        long maxRequestSize = 500 * 1024 * 1024; // 500 MB en octets
        int fileSizeThreshold = 0; // Vous pouvez ajuster cela en fonction de vos besoins
        return new MultipartConfigElement(null, maxFileSize, maxRequestSize, fileSizeThreshold);
    }


    
}
