package com.nop.services;

import com.nop.entity.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

}
