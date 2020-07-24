package com.Biditvats.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(filterName="AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        System.out.println("AuthenticationFilter Object is Created");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("AuthenticationFilter Object is destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("AuthenticationFilter is Authentication Request");
		chain.doFilter(request, response);
		System.out.println("AuthenticationFilter is Authentication Response");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthenticationFilter is Initialized");
	}

}
