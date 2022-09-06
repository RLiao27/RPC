package ran.pro_netty_rpc;

import org.junit.Test;

import ran.rpc.client.ClientRequest;
import ran.rpc.client.TcpClient;
import ran.rpc.util.Response;



public class TestTcp {
	@Test
	public void testGetResponse() {
		ClientRequest request = new ClientRequest();
		request.setContent("测试TCP长连接");
		Response response = TcpClient.send(request);
		System.out.println(response.getResult());
		
	}
	public void testSaveUser() {
		ClientRequest request = new ClientRequest();
		request.setContent("测试TCP长连接");
		Response response = TcpClient.send(request);
		System.out.println(response.getResult());
		
	}
	
}
