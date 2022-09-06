package ran.rpc.medium;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import ran.rpc.param.ServerRequest;
import ran.rpc.util.Response;



public class Medium {
	public static final HashMap<String, BeanMethod> mediummap = new HashMap<String, BeanMethod>();
	private static Medium medium = null;

	private Medium() {
	}

	public static Medium newInstance() {
		if (medium == null) {
			medium = new Medium();
		}

		return medium;
	}

	public Response process(ServerRequest request) {
		Response result = null;
		try {
			String command = request.getCommand();
			BeanMethod beanMethod = mediummap.get(command);
			if (beanMethod == null) {
				return null;
			}

			Object bean = beanMethod.getBean();
			Method method = beanMethod.getMethod();
			Class type = method.getParameterTypes()[0];
			Object content = request.getContent();
			Object args = JSONObject.parseObject(JSONObject.toJSONString(content), type);

			result = (Response) method.invoke(bean, args);
			result.setId(request.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
