package com.ran.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import client.annotation.RemoteInvoke;
import user.bean.User;
import user.remote.UserRemote;


@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes=RemoteInvokeTest.class)
	@ComponentScan("\\")
	public class RemoteInvokeTest {
		public static List<User> list = new ArrayList<User>();
		@RemoteInvoke
		public static UserRemote userremote;
		public static User user;
		public static Long count = 0l;
		
		static{
			user = new User();
			user.setId(1000);
			user.setName("张三");
		}
		@Test
		public void testSaveUser(){
			User user = new User();
			user.setId(1000);
			user.setName("张三");
	//		Response response = UserRemote.saveUser(user);
			//UserRemote.testUser(user);
//			Long start = System.currentTimeMillis();
//			for(int i=1;i<10000;i++){
//				userremote.saveUser(user);
//			}
//			Long end = System.currentTimeMillis();
//			Long count = end-start;
//			System.out.println("总计时:"+count/1000+"秒");
			
		}			


	}

