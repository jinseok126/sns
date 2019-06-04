/**
 * 
 */
package com.sns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author pc10
 *
 */
@Controller
public class ChatController {

	@GetMapping("/chat")
	public String chat() {
		return "chat/chatting";
	}
}
