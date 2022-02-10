package kr.ne.abc.member.service;

import kr.ne.abc.member.dto.MemberDTO;

public interface MemberService {

	/** memberSignin **/
	public MemberDTO memberSignIn(String username);
	
	/**  signUp  **/
	public int signUp(MemberDTO memberDTO);
	
}
