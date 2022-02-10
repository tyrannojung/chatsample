package kr.ne.abc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import kr.ne.abc.member.service.MemberSecurityService;
import lombok.RequiredArgsConstructor;



@Configuration
@EnableWebSecurity // 1
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { // 2

  private final MemberSecurityService securityUserDetailsService; // 3

  @Override
  public void configure(WebSecurity web) { // 4
    web.ignoring().antMatchers("/css/**", "/js/**", "/img/**"); //static 하위폴더는 무조건 접근이 가능해야 하기 때문에 인증을 무시해야 한다.
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception { // 5
    http.authorizeRequests() // 6
            .antMatchers("/login", "/signup", "/user").permitAll() // 누구나 접근 허용
            .antMatchers("/").hasRole("USER") // USER, ADMIN만 접근 가능
            .antMatchers("/admin").hasRole("ADMIN") // ADMIN만 접근 가능
            .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
        .and() 
          .formLogin() // 7
            .loginPage("/login") // 로그인 페이지 링크
            .defaultSuccessUrl("/") // 로그인 성공 후 리다이렉트 주소
        .and()
          .logout() // 8
            .logoutSuccessUrl("/login") // 로그아웃 성공시 리다이렉트 주소
	    .invalidateHttpSession(true) // 세션 날리기
	    .and()
        .cors().configurationSource(corsConfigurationSource())
	    .and()
	    .csrf().disable();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception { // 9
    auth.userDetailsService(securityUserDetailsService)
    	// 해당 서비스(userService)에서는 UserDetailsService를 implements해서 
        // loadUserByUsername() 구현해야함 (서비스 참고)
    	.passwordEncoder(new BCryptPasswordEncoder()); 
   }
  
  // CORS 허용 적용
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();

      configuration.addAllowedOriginPattern("*");;
      configuration.addAllowedHeader("*");
      configuration.addAllowedMethod("*");
      configuration.setAllowCredentials(true);

      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);
      return source;
  }
  
}