package com.nop.services;

public interface SecurityService {
	String findLoggedInUsername();
    boolean addLoginUserToSession(String username, String password);
}
