package com.revature.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.revature.models.Ses;
import com.revature.models.Users;

@Service
public class SesService {

	private Map<String, Ses> sessions = new HashMap<String, Ses>();

	public Ses getSession(String ip) {
		return sessions.get(ip);
	}

	public void makeSes(String ip, Users user) {
		Ses session = new Ses(ip, user, true);
		sessions.put(ip, session);
	}
	
	
	
}
