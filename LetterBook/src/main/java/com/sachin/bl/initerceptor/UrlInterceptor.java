package com.sachin.bl.initerceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UrlInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		System.out.println(request.getServletPath());
		String[] split = request.getServletPath().split("/");
		if (split.length > 1) {

			for (String pathSeg : split) {
				if (allowUrls.contains(pathSeg)) {
					return true;
				}
			}
		}
		Object user = request.getSession().getAttribute("User");
		if (user == null) {

			response.sendRedirect("/");
			return false;
		}

		return true;
	}

	public List<String> allowUrls;// 还没发现可以直接配置不拦截的资源，所以在代码里面来排除

	public void setAllowUrls(List<String> allowUrls) {
		this.allowUrls = allowUrls;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
