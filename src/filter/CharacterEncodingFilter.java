package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		chain.doFilter(request, response);

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	//	<filter-mapping>
//		<filter>
//		<filter-name>CharacterEncodingFilter</filter-name>
//		<filter-class>filter.CharacterEncodingFilter</filter-class>
//		<init-param>
//			<param-name>requestEncoding</param-name>
//			<param-value>UTF-8</param-value>
//		</init-param>
//	</filter>
//	<filter-mapping>
//		<filter-name>CharacterEncodingFilter</filter-name>
//		<url-pattern>/*</url-pattern>
//	</filter-mapping>
	}

}
