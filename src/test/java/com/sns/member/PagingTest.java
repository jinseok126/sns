package com.sns.member;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.sns.domain.MemberVO;
import com.sns.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PagingTest {

	@Autowired
	MemberRepository memberRepo;
	
	@Test
	public void contextLoads() {
		
		// 0, 5 ==> 1~5
		// 1, 5 ==> 6~10 
		Pageable pageable = PageRequest.of(1, 5);
		Page<MemberVO> memberPage = memberRepo.findAll(pageable);
		List<MemberVO> member = memberPage.getContent();
		
		log.info("멤버 = "+member);
	}
}

