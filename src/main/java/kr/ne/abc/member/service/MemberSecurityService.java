package kr.ne.abc.member.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.ne.abc.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService {
	
	private final MemberService memberService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberDTO users = memberService.memberSignIn(username);
		if(users == null) {
			 throw new UsernameNotFoundException("username " + username + " not found");
		}
		
		return users;
	}
	
}
