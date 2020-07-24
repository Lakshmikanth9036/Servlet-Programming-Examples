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
 * Servlet Filter implementation class ValidationFilter
 */
@WebFilter(filterName="ValidationFilter")
public class ValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidationFilter() {
        System.out.println("ValidationFilter Object is Created");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("ValidationFilter Object is destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ValidationFilter is Validating Request");
		chain.doFilter(request, response);
		System.out.println("ValidationFilter is Validating Response");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("ValidationFilter is Initialized");
	}

}
