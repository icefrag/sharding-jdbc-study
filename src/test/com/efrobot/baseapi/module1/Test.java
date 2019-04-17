/**
 * 
 */
package com.efrobot.baseapi.module1;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;
import com.efrobot.toolkit.util.http.RestClient;
import com.efrobot.xx.baseapi.module1.pojo.Person;

/** 
* @包名 com.efrobot.baseapi.module1
* @类名 Test.java
* @作者 wurui
* @创建日期 2016年7月9日
* @描述 
* @版本 V 1.0
*/
public class Test {
	private static RestTemplate restTemplate = RestClient.getInstance();

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			//			Map<String, String> params = new HashMap<String, String>();
			//			params.put("robotId", "100000000031");
			//			MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<String, String>();
			//			requestEntity.add("robotId", "100000000031");
			//			HttpEntity<?> entity = new HttpEntity(obj, RestClient.buildBasicHTMLHeaders());
			//			String str = restTemplate.getForObject("http://101.200.179.212/v1/cash/balance", String.class, params);
			//			String str = restTemplate.getForObject("http://101.200.179.212/v1/cash/balance?robotId={robotId}", String.class, "100000000031");
			//			String str = restTemplate.postForObject("http://101.200.179.212/v1/cash/balance", requestEntity, String.class);
			String url = "http://123.56.181.126:8095/api/v1/interface/robot/info";
			String url1 = "http://localhost/medusa/v1/person";
			Person person = new Person();
			person.setName("牛逼");
			person.setAge(12);
			person.setEmail("icefrag@126.com");
			System.out.println(JSONObject.toJSONString(person));
			//			JSONObject obj = new JSONObject();
			MultiValueMap<String, String> obj = new LinkedMultiValueMap<String, String>();
			obj.add("name", "牛逼");
			obj.add("age", "12");
			obj.add("email", "icefrag@126.com");
			System.out.println(JSONObject.toJSONString(obj));

			JSONObject obj1 = new JSONObject();
			obj1.put("name", "牛逼");
			obj1.put("age", "12");
			obj1.put("email", "icefrag@126.com");
			System.out.println(JSONObject.toJSONString(obj1));

			//			HttpEntity<String> entity = new HttpEntity(obj1, RestClient.buildBasicJSONHeaders());
			//			System.out.println(entity.hasBody());
			String str = restTemplate.postForObject(url1, obj, String.class);
			System.out.println(str);
			/*
			Collection<Class<? extends IOException>> clazzes = Arrays.asList(InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class);
			IOException exception = new SocketTimeoutException();
			for (final Class<? extends IOException> rejectException : clazzes) {
				System.out.println(rejectException);
				if (rejectException.isInstance(exception)) {
					System.out.println(rejectException + "----" + exception);
					System.out.println("异常属于当前异常列表");
				}
			}
			*/
		}
	}
}
