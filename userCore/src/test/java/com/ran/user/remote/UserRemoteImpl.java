package com.ran.user.remote;
import java.util.List;
import javax.annotation.Resource;
import com.ran.user.model.User;
import com.ran.user.service.UserService;
import ran.rpc.annotation.Remote;
import ran.rpc.util.ResponseUtil;

@Remote
public class UserRemoteImpl implements UserRemote {

	@Resource
	private UserService service;

	public Object saveUser(User user) {
		service.saveUser(user);
		return ResponseUtil.createSuccessResponse(user);

	}

	public Object saveUsers(List<User> userlist) {
		service.saveUserList(userlist);
		return ResponseUtil.createSuccessResponse(userlist);

	}
}