package com.sns.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sns.domain.MemberVO;
import com.sns.repository.MemberRepository;
import com.sns.util.SHA256Util;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {
	
	@Autowired
	MemberRepository memberRepo;
	
	
	@Test
	public void contextLoads() {
		
		MemberVO member = new MemberVO();
		
		member.setMemberId("admin");
		member.setMemberPw("123456");
		member.setMemberName("관리자");
		
		member.setMemberPw(SHA256Util.getSHA256(member.getMemberPw()));
		member.setMemberPw(SHA256Util.getEncrypt(member.getMemberPw(), member.getMemberSalt()));
		
		memberRepo.save(member);
	}
}

