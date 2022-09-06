package ran.rpc.remote;

import java.util.List;

import javax.annotation.Resource;

import ran.rpc.annotation.Remote;
import ran.rpc.bean.User;
import ran.rpc.service.UserService;
import ran.rpc.util.Response;
import ran.rpc.util.ResponseUtil;

 
@Remote
public class UserRemoteImpl implements UserRemote {

	@Resource
	private UserService service;

	public Response saveUser(User user) {
		service.saveUser(user);
		Response response = ResponseUtil.createSuccessResponse(user);

		return response;
	}

	public Response saveUsers(List<User> userlist) {
		service.saveUserList(userlist);
		Response response = ResponseUtil.createSuccessResponse(userlist);

		return response;
	}
}