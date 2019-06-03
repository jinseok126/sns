/**
 * 
 */
package com.sns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pc10
 *
 */
@Controller
@RequestMapping("admin")
@Slf4j
public class AdminController {

	@GetMapping("/")
	public String home() {
		log.info("admin");
		return "admin/home";
	}
}
