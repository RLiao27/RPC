package ran.rpc.remote;

import java.util.List;

import ran.rpc.bean.User;
import ran.rpc.util.Response;




public interface UserRemote {
	public Response saveUser(User user);
	public Response saveUsers(List<User> userlist);
}
