package net.kaba.ecomspring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource ;


import java.util.Arrays;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
   public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
       return httpSecurity
               .csrf(AbstractHttpConfigurer::disable)
               .headers(h->h.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
               .authorizeHttpRequests(ar -> ar.requestMatchers("/api/**","/swagger-ui.html","/swagger-ui/**","/v3/**","/h2-console/**").permitAll())
               .authorizeHttpRequests(ar -> ar.anyRequest().authenticated())
               .build();
   }

   @Bean
  public CorsConfigurationSource corsConfiguration (){
        CorsConfiguration configuration = new CorsConfiguration() ;
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList());
        configuration.setAllowedHeaders(Arrays.asList());
        configuration.setExposedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source ;
   }
}
