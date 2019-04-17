package com.efrobot.xx.module1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.efrobot.xx.baseapi.module1.pojo.Person;
import com.efrobot.xx.module1.service.DemoService;

/**
 * 
 * @Description Demo 用Controller
 *
 * @author wurui. Email:wurui@ren001.com
 * @date 2015年12月11日 下午6:44:10
 */
@Controller
@RequestMapping("/v1")
public class DemoController {
	private static final Logger log = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private DemoService firstService;

	/**
	 * 
	 * @Description 对应get请求
	 *
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/person/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Person queryAppByAppId(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		log.debug("执行请求获取用户");
		return firstService.queryAppByAppId(id);
	}

	/**
	 * 
	 * @Description 执行delete删除指定id的person
	 *
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/person/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deletePerson(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		log.debug("执行请求删除指定id的person");
		firstService.deleteByPrimaryKey(id);
		JSONObject jsonObject = new JSONObject();
		return jsonObject.put("msg", "删除人员信息成功");
	}

	/**
	 * 
	 * @Description 执行post方法创建一个person
	 *
	 * @param person
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/person", method = RequestMethod.POST)
	@ResponseBody
	public Object addPerson(Person obj, @RequestHeader("content-type") String type) throws Exception {
		log.debug(type);
		log.debug("执行请求创建person" + JSONObject.toJSONString(obj));
		//		JSONObject jsonObject = new JSONObject();
		//		if (person.getName() != null) {
		//			this.firstService.insert(person);
		//			jsonObject.put("msg", "注册人员信息成功");
		//		}
		Thread.sleep(30 * 1000);
		return JSONObject.toJSONString(obj);
	}

	/**
	 * 
	 * @Description put方法更新数据
	 *
	 * @param person
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/person", method = RequestMethod.PUT)
	@ResponseBody
	public Object updatePerson(Person person) throws Exception {
		log.debug("执行请求更新person");
		JSONObject jsonObject = new JSONObject();
		if (person.getName() != null) {
			this.firstService.updateByPrimaryKeySelective(person);
			jsonObject.put("msg", "更新人员信息成功");
		}
		return jsonObject;
	}
}
