package ran.pro_netty_rpc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ran.rpc.annotation.RemoteInvoke;
import ran.rpc.bean.User;
import ran.rpc.remote.UserRemote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RemoteInvokeTest.class)
@ComponentScan("\\")
public class RemoteInvokeTest {
	@RemoteInvoke
	private UserRemote userRemote;

	@Test
	public void testSaveUser() {
		User user = new User();
		user.setId(100);
		user.setName("张三");
		userRemote.saveUser(user);
		System.out.println("成功了");
	}

}