package com.sns.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sns.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SelectByNameTest {

	@Autowired
	MemberRepository memberRepo;
	
	@Test
	public void contextLoads() {
		
		log.info("정보 = "+memberRepo.findByMemberName("테스트_1"));
	}
}

