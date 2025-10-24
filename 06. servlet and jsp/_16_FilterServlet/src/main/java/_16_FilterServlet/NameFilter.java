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
public class NameFilter implements Filter {

	public NameFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String name = request.getParameter("aname");
		PrintWriter out = response.getWriter();

		if (name.length() > 3)
			chain.doFilter(request, response);
		else
			out.println("Invalid response");

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}
