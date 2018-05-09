package org.zerock.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import lombok.extern.log4j.Log4j;

/**
 * 
 * @author zzz
 *
 */
@Log4j
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
//로그인안하면 접근못하게하는 인터셉터
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result= false;
		HttpSession session = request.getSession();//세션에 있는 내용 그대로 쓰면됨
		
		Cookie loginCookie = WebUtils.getCookie(request, "login");
		//webutil로 간단하게 쿠키 끄집어내기
		
		if(session.getAttribute("member")!=null) {
			result = true;
		}else if(loginCookie != null) { 
			//세션에는 없는데 쿠기가 있는 상황
			//지난번 로그인했을때의 jSessionId 값
			String key = loginCookie.getValue();
			
			log.info("Cookie value: "+ key);
			
		}else {
			response.sendRedirect("/login");
		}
		log.info("check login user: " + result);	
		return result;
	}
}
