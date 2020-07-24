package com.Biditvats.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class WelcomeListener
 *
 */
@WebListener
public class WelcomeListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public WelcomeListener() {
    	System.out.println("WelcomeListener Object is Created!");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("WelcomeListener is Destroyed!");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println("WelcomeListener is Initialized!");
    }
	
}
