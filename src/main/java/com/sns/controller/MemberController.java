/**
 * 
 */
package com.sns.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sns.domain.MemberVO;
import com.sns.repository.MemberRepository;
import com.sns.util.SHA256Util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pc10
 *
 */
@Controller
@Slf4j
@RequestMapping("member")
public class MemberController {

	@Autowired
	MemberRepository memberRepo;
	
	@GetMapping("join")
	public String join() {
		
		return "member/join";
	}
	/*
	@PostMapping("join")
	public String join() {
		
		return "member/join";
	}
	*/
	@GetMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	@PostMapping("login")
	@ResponseBody
	public String login(@ModelAttribute MemberVO member, HttpSession session) {
		
		String result = "";
		
		log.info("member = "+member);
		String id = member.getMemberId();
		String pw = member.getMemberPw();
		MemberVO member2 = memberRepo.findBymemberId(id);
		
		if(member2 != null) {
			String salt = member2.getMemberSalt();
			if(member2.getMemberPw() == SHA256Util.getEncrypt(pw, salt) || 
			   member2.getMemberPw().equals(SHA256Util.getEncrypt(pw, salt))) {
				
				session.setAttribute("memberId", id);
				
				log.info("session = " + session.getAttribute("memberId"));
				result = "login";
				
			} else {
				result = "";
			}
		} else {
			result = "";
		}
		
		return result;
	}
	
	@GetMapping("logout")
	@ResponseBody
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
}
