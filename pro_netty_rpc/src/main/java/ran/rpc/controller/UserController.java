package ran.rpc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import ran.rpc.bean.User;
import ran.rpc.service.UserService;
import ran.rpc.util.Response;
import ran.rpc.util.ResponseUtil;

@Controller
public class UserController {
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
