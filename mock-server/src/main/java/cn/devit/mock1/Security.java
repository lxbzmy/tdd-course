package cn.devit.mock1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.WebAttributes;
import org.springframework.util.MimeTypeUtils;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {

  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests(authorize -> authorize
            .antMatchers("/hello").permitAll()
            .anyRequest().authenticated())
        .formLogin()
        .successHandler((
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) -> {
          response.setContentType(
              MimeTypeUtils.APPLICATION_JSON_VALUE);
          String username = authentication.getPrincipal().toString();
          response.getWriter()
              .write("{\"success\":true,\"continue\":\"/\",\"username\":\""+username+"\"}");
          response.getWriter().close();
          HttpSession session = request.getSession(false);
          if (session == null) {
            return;
          }
          session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }).and()
        .logout().logoutSuccessHandler((HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) -> {
          response.setContentType(
              MimeTypeUtils.APPLICATION_JSON_VALUE);
          response.getWriter()
              .write("{\"success\":true,\"continue\":\"/\"}");
          response.getWriter().close();
        });
  }

  @Bean
  public UserDetailsService userDetailsService() {
    // ensure the passwords are encoded properly
    UserBuilder users = User.withDefaultPasswordEncoder();
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(
        users.username("user").password("password").roles("USER").build());
    manager.createUser(users.username("admin").password("password")
        .roles("USER", "ADMIN").build());
    manager.createUser(
        users.username("root").password("root").roles("USER", "ADMIN").build());
    return manager;
  }
}
