package net.softsociety.exam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 정보 (시큐리티를 사용한 회원 인증에 사용)
 * UserDetails 인터페이스를 implements
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	String memberid;
	String memberpw;
	String membername;	
	String phone;
	boolean enabled;			//계정상태. 1:사용가능, 0:사용불가능
	String rolename;			//사용자 구분. 'ROLE_USER':일반사용자

	public Member toMember() {
		Member member = new Member();
		member.setMemberid(memberid);
		member.setMemberpw(memberpw);
		member.setMembername(membername);
		member.setPhone(phone);
		member.setEnabled(enabled);
		member.setRolename(rolename);
		return member;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
}