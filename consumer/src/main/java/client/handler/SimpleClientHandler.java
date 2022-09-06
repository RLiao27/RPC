package client.handler;

import com.alibaba.fastjson.JSONObject;

import client.core.DefaultFuture;
import client.param.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if ("ping".equals(msg.toString())) {
			ctx.channel().writeAndFlush("pong\r\n");
			return;
		}
		// 设置response
		Response response = JSONObject.parseObject(msg.toString(), Response.class);
		DefaultFuture.receive(response);// 通过response的ID可以在map中找到对应的Request,并为相应的request设置response,使得调用get()客户端得到结果

	}

}
