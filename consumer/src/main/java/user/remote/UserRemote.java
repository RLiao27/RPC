package user.remote;

import java.util.List;

import client.param.Response;
import user.bean.User;


public interface UserRemote {
	public Response saveUser(User user);
	public Response saveUsers(List<User> userlist);
}
