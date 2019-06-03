/**
 * 
 */
package com.sns.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pc10
 *
 */
@Component
@Slf4j
public class AdminSessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		boolean flag = false;
		
		log.info("preHandle");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memberId");
		log.info("id= "+id);
		
		if(id == "admin" || id.equals("admin")) {
			log.info("admin 입장");
			flag = true;
		} else {
			log.info("관리자 아님");
			flag = false;
			response.sendRedirect(request.getContextPath()+"/");
		}
		
	    return flag;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
	
	}
}
