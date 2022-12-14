package kr.co.seoulit.common.advice;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest rep = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Access-Control-Allow-Methods", "*");
		res.setHeader("Access-Control-Allow-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, "
				+ "Authorization, Origin, Accept, "
				+ "Access-Control-Request-Origin, Access-Control-Request-Credentials, "
				+ "Access-Control-Request-Methods, Access-Control-Request-Max-Age, Access-Control-Request-Headers");

		if("OPTIONS".equalsIgnoreCase(rep.getMethod())) {
			res.setStatus(HttpServletResponse.SC_OK);
		}else {
			chain.doFilter(request, response);			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
