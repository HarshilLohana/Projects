package com.listner;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListnerSession implements HttpSessionListener{
	public static int userCount;
	public void sessionCreated(HttpSessionEvent arg0) {
		userCount++;
		System.out.println("user IN"+userCount);
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		userCount--;
		System.out.println("user OUT"+userCount);
		
	}
	
}
