package kr.ne.abc.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.ne.abc.member.dto.MemberDTO;

@Repository
@Mapper
public interface MemberMapper {
	
	/** memberSignIn **/
	public MemberDTO memberSignIn(String username);
	
	/**  signUp  **/
	public int signUp(MemberDTO memberDTO);
	
}
