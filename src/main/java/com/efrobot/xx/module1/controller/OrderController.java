package com.efrobot.xx.module1.controller;

import com.efrobot.xx.baseapi.module1.pojo.TOrder;
import com.efrobot.xx.module1.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 
 * @Description Demo 用Controller
 *
 * @author wurui. Email:wurui@ren001.com
 * @date 2015年12月11日 下午6:44:10
 */
@Controller
@RequestMapping("/v1")
public class OrderController {
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

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
	@RequestMapping(path = "/order", method = RequestMethod.GET)
	@ResponseBody
	public Integer queryAppByAppId() throws Exception {
		log.debug("执行请求获取用户");
		return firstService.saveOrder();
	}

	@RequestMapping(path = "/order/{id}", method = RequestMethod.GET)
	@ResponseBody
	public TOrder query(@PathVariable("id") Long id) throws Exception {
		log.debug("执行请求获取用户");
		return firstService.queryById(id);
	}

	@RequestMapping(path = "/order/{start}/{end}", method = RequestMethod.GET)
	@ResponseBody
	public List<TOrder> query(@PathVariable("start") Long start, @PathVariable("end") Long end) throws Exception {
		log.debug("执行请求获取用户");
		return firstService.queryByRange(start,end);
	}

	@RequestMapping(path = "/order/between/{start}/{end}", method = RequestMethod.GET)
	@ResponseBody
	public List<TOrder> query2(@PathVariable("start") Long start, @PathVariable("end") Long end) {
		log.debug("执行请求获取用户");
		try {
			return firstService.queryByRangeBetweenAnd(start,end);

		}catch (Exception e){
			log.error("error:",e);
		}
		return null;
	}

	@RequestMapping(path = "/order/t", method = RequestMethod.GET)
	@ResponseBody
	public Integer queryAppByAppId2() throws Exception {
		log.debug("执行请求获取用户");
		firstService.transactionTest();
		return 0;
	}
}
