package com.efrobot.xx.module1.service;

import com.efrobot.xx.baseapi.module1.pojo.Person;
import com.efrobot.xx.baseapi.module1.pojo.TOrder;

import java.util.List;

public interface DemoService {
    public Person queryAppByAppId(int id) throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int updateByPrimaryKeySelective(Person record);

    List<Person> queryPerson4ServerDemo();

    Integer saveOrder();

    TOrder queryById(Long id);

    List<TOrder> queryByRange(Long start, Long end);

    List<TOrder> queryByRangeBetweenAnd(Long start, Long end);

    void transactionTest();
}
