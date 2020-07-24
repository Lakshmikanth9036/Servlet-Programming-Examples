package com.Biditvats.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.Biditvats.db.Database;



/**
 * Application Lifecycle Listener implementation class SqlTableListener
 *
 */
@WebListener
public class SqlTableListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SqlTableListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("Application is Stopped!");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         try{
        	 String sql = "CREATE TABLE IF NOT EXISTS user_master1("
        			 	+"user_id INT UNIQUE NOT NULL AUTO_INCREMENT,"
        			 	+"full_name VARCHAR(50),"
        			 	+"email VARCHAR(50),"
        			 	+"mobile VARCHAR(50),"
        			 	+"PRIMARY KEY(user_id)"
        			 	+ ")";
        	 
        	 Connection connection = Database.getConnection();
        	 PreparedStatement pStatement = connection.prepareStatement(sql);
        	 pStatement.execute();
        	 
         }catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
    }
}
