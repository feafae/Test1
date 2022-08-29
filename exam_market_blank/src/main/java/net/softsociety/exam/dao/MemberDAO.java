package net.softsociety.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Member;

/**
 * 회원정보 관련 매퍼
 */
@Mapper
public interface MemberDAO {
	public int saveMember(Member member);

	public Member findMemberById(String id);

	public Member findMemberByIdAndPassword(Member member);

}
