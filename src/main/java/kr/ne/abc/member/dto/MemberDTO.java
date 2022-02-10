package kr.ne.abc.member.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component("MemberDTO")
@SuppressWarnings("serial")
public class MemberDTO implements UserDetails {
	  
	  private String email;
	  private String password;
	  private String auth;
	  
	@Override
	public String toString() {
		return "MemberDTO [email=" + email + ", password=" + password + ", auth=" + auth + "]";
	}
	
	
    /** 
    TO DO : 스프링 시큐리티
    */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    Set<GrantedAuthority> roles = new HashSet<>();

	    for (String role : auth.split(",")) {
	      roles.add(new SimpleGrantedAuthority(role));
	    }

	    return roles;
	}
	
	// 사용자의 id를 반환 (unique한 값)
	@Override
	public String getUsername() {
		return email;
	}
	
	// 사용자의 password를 반환
	@Override
	public String getPassword() {
		return password;
	}

	// 계정 만료 여부 반환
	@Override
	public boolean isAccountNonExpired() {
		// 만료되었는지 확인하는 로직
		return true; // true -> 만료되지 않았음
	}
	
	// 계정 잠금 여부 반환
	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠금되었는지 확인하는 로직
		return true; // true -> 잠금되지 않았음
	}
	
	// 패스워드의 만료 여부 반환
	@Override
	public boolean isCredentialsNonExpired() {
		// 패스워드가 만료되었는지 확인하는 로직
		return true; // true -> 만료되지 않았음
	}
	
	// 계정 사용 가능 여부 반환
	@Override
	public boolean isEnabled() {
		// 계정이 사용 가능한지 확인하는 로직
		return true; // true -> 사용가능
	}
	  
}