package com.Biditvats.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ActiveUserCountListener
 *
 */
@WebListener
public class ActiveUserCountListener implements HttpSessionListener {

	private static int activeUsers;

    public ActiveUserCountListener() {
        // TODO Auto-generated constructor stub
    }
    
    public static int getActiveUsers(){
    	return activeUsers;
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         activeUsers++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	activeUsers--;
    }
	
}
