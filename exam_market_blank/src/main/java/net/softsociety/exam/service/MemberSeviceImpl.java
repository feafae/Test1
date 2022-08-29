package net.softsociety.exam.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.softsociety.exam.dao.MemberDAO;
import net.softsociety.exam.domain.Member;

@RequiredArgsConstructor
@Service
public class MemberSeviceImpl implements MemberService {

	
	private final MemberDAO memberDao;
	
	
	public void saveMember(Member member) {
		memberDao.saveMember(member);
	}
	
	public Member findMember(String id) {
		return memberDao.findMemberById(id);
	}
	
	public Member findMember(Member member) {
        return memberDao.findMemberByIdAndPassword(member);
    }

   

}
