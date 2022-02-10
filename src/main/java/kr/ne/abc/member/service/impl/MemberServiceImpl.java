package kr.ne.abc.member.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.ne.abc.member.dto.MemberDTO;
import kr.ne.abc.member.mapper.MemberMapper;
import kr.ne.abc.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service("MemberService")
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberMapper memberMapper;
	
	/** memberSignIn **/
	@Override
	public MemberDTO memberSignIn(String username) {	
		return memberMapper.memberSignIn(username);
	}
	
	/**  signUp  **/
	@Override
	public int signUp(MemberDTO memberDTO) {
		
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    memberDTO.setPassword(encoder.encode(memberDTO.getPassword()));
	    
		return memberMapper.signUp(memberDTO);
	}
	
}
