package com.sns.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.sns.vo.Greeting;
import com.sns.vo.ChatMessage;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
    @SendTo("/chat/app")
    public Greeting greeting(ChatMessage message) throws Exception {
		
    	// Thread.sleep(1000); // simulated delay
    	return new Greeting(HtmlUtils.htmlEscape(message.getName()));
    }
}
