package _16_FilterServlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/addAlien")
public class IdFilter implements Filter {

	public IdFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		int aid = Integer.parseInt(request.getParameter("aid"));
		PrintWriter out = response.getWriter();

		if (aid > 1)
			chain.doFilter(request, response);
		else
			out.println("Invalid response");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}
