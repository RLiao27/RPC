package com.ran.user.remote;

import java.util.List;

import com.ran.user.model.User;


public interface UserRemote {
	public Object saveUser(User user);
	public Object saveUsers(List<User> userlist);
}
