package net.softsociety.exam.domain;

import lombok.Data;

@Data
public class LoginForm {
	private String memberid;
	private String password;
	
	public Member toMember() {
		Member member = new Member();
		member.setMemberid(memberid);
		member.setMemberpw(memberid);
		return member;
	}
}
