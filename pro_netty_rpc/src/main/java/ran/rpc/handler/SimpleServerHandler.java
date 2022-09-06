package ran.rpc.handler;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSONObject;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import ran.rpc.medium.Medium;
import ran.rpc.param.ServerRequest;
import ran.rpc.util.Response;


public class SimpleServerHandler extends ChannelInboundHandlerAdapter {
	private static final Executor exec = Executors.newFixedThreadPool(10);
	@Override
	public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
//		System.out.println("服务器Handler:"+msg.toString());
//		ServerRequest serverRequest = JSONObject.parseObject(msg.toString(), ServerRequest.class);
//		System.out.println(serverRequest.getCommand());
		exec.execute(new Runnable() {
			
			public void run() {
				ServerRequest serverRequest = JSONObject.parseObject(msg.toString(), ServerRequest.class);
				System.out.println(serverRequest.getCommand());
				Medium medium = Medium.newInstance();//生成中介者模式
				
				Response response = medium.process(serverRequest);
				
				//向客户端发送Response
				ctx.channel().writeAndFlush(JSONObject.toJSONString(response)+"\r\n");
			}
		});

//	@Override
//	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		// ctx.channel().writeAndFlush("is OK\r\n");
//		// ctx.channel().close();
//		ServerRequest request = JSONObject.parseObject(msg.toString(), ServerRequest.class);
//		Response response = new Response();
//		response.setId(request.getId());
//		response.setResult("is OK");
//		ctx.channel().writeAndFlush(JSONObject.toJSONString(response));
//		ctx.channel().writeAndFlush("\r\n");
//
//	}
//
//	@Override
//	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//		if (evt instanceof IdleStateHandler) {
//			IdleStateEvent event = (IdleStateEvent) evt;
//			if (event.state().equals(IdleState.READER_IDLE)) {
//				System.out.println("read idle");
//				ctx.channel().close();
//			} else if (event.state().equals(IdleState.WRITER_IDLE)) {
//				System.out.println("write idle");
//			} else if (event.state().equals(IdleState.ALL_IDLE)) {
//				System.out.println("all idle");
//				ctx.channel().writeAndFlush("ping\r\n");
//
//			}
//
//		}
//
//	}
	}}
