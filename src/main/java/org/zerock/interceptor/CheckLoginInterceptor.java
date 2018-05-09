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
//�α��ξ��ϸ� ���ٸ��ϰ��ϴ� ���ͼ���
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result= false;
		HttpSession session = request.getSession();//���ǿ� �ִ� ���� �״�� �����
		
		Cookie loginCookie = WebUtils.getCookie(request, "login");
		//webutil�� �����ϰ� ��Ű �������
		
		if(session.getAttribute("member")!=null) {
			result = true;
		}else if(loginCookie != null) { 
			//���ǿ��� ���µ� ��Ⱑ �ִ� ��Ȳ
			//������ �α����������� jSessionId ��
			String key = loginCookie.getValue();
			
			log.info("Cookie value: "+ key);
			
		}else {
			response.sendRedirect("/login");
		}
		log.info("check login user: " + result);	
		return result;
	}
}
