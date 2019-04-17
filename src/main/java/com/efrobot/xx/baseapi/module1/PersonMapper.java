package com.efrobot.xx.baseapi.module1;

import java.util.List;

import com.efrobot.xx.baseapi.module1.pojo.Person;

public interface PersonMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
    
    /**
     * 查询person表中的所有数据
     * @return
     */
    List<Person> queryPerson4ServerDemo();
}