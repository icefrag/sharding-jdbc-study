/**
 * 
 */
package com.efrobot.baseapi.module1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.efrobot.xx.baseapi.module1.PersonMapper;
import com.efrobot.xx.baseapi.module1.pojo.Person;

/**
 * @Description 测试类
 *
 * @author wurui. Email:wurui@ren001.com
 * @date 2015年12月14日 上午11:12:36
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
@Transactional
public class PersonMapperTest {
	@Autowired
	private PersonMapper personMapper;

	@Test
	public void insert() {
		Person record = new Person();
		record.setAge(0);
		record.setEmail("wurui@126.com");
		record.setName("曹文岭");
		personMapper.insert(record);
	}
}
