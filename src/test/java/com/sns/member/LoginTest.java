package com.sns.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sns.domain.MemberVO;
import com.sns.repository.MemberRepository;
import com.sns.util.SHA256Util;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoginTest {

	@Autowired
	MemberRepository memberRepo;
	
	@Test
	public void contextLoads() {
		
		MemberVO member = new MemberVO();
		
		member.setMemberId("spring01");
		member.setMemberPw("12345");
		
		member.setMemberPw(SHA256Util.getSHA256(member.getMemberPw()));
		
		MemberVO member2 = memberRepo.findByMemberId(member.getMemberId());
		
		if(member2 == null) {
			log.info("아이디 X");
		} else {
			log.info("아이디 O");
			String salt = member2.getMemberSalt();
			
			String pw = SHA256Util.getEncrypt(member.getMemberPw(), salt);
			if(member2.getMemberPw() == pw || member2.getMemberPw().equals(pw)) {
				log.info("로그인 성공!!");
			} else {
				log.info("아이디는 존재하지만 비밀번호가 다름");
			}
		}
	
	}
}

