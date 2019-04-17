package com.efrobot.xx.module1.service.impl;

import com.efrobot.xx.baseapi.module1.PersonMapper;
import com.efrobot.xx.baseapi.module1.TOrderMapper;
import com.efrobot.xx.baseapi.module1.pojo.Person;
import com.efrobot.xx.baseapi.module1.pojo.TOrder;
import com.efrobot.xx.module1.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private TOrderMapper tOrderMapper;

    @Override
    public Person queryAppByAppId(int id) throws Exception {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return personMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Person record) {
        return personMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Person record) {
        return personMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Person> queryPerson4ServerDemo() {
        return personMapper.queryPerson4ServerDemo();
    }

    @Override
    public Integer saveOrder() {
        TOrder order = new TOrder();
        order.setCreateTime(new Date());
//        order.setId((int)(1+Math.random()*(10-1+1)));
        order.setUserId((int) (1 + Math.random() * (10 - 1 + 1)));
        return tOrderMapper.insert(order);
    }

    @Override
    public TOrder queryById(Long id) {
        return tOrderMapper.queryById(id);
    }

    @Override
    public List<TOrder> queryByRange(Long start, Long end) {
        return tOrderMapper.queryByRange(start, end);
    }

    @Override
    public List<TOrder> queryByRangeBetweenAnd(Long start, Long end) {
        return tOrderMapper.queryByRangeBetweenAnd(start, end);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transactionTest() {
        TOrder order = new TOrder();
        order.setCreateTime(new Date());
        order.setUserId((int) (1 + Math.random() * (10 - 1 + 1)));
        tOrderMapper.insert(order);
    }
}
