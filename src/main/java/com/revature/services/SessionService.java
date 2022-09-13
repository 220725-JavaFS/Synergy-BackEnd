package com.revature.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.revature.models.Session;
import com.revature.models.Users;

@Service
public class SessionService {

	private Map<String, Session> sessions = new HashMap<String, Session>();

	public Session getSession(String ip) {
		return sessions.get(ip);
	}

	public void makeSes(String ip, Users user) {
		Session session = new Session(ip, user, true);
		sessions.put(ip, session);
	}
	
	
	
}
