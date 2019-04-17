package com.efrobot.xx.baseapi.module1;

import com.efrobot.xx.baseapi.module1.pojo.TOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrderMapper {
    int insert(TOrder tOrder);

    TOrder queryById(Long id);

    List<TOrder> queryByRange(@Param("start") Long start, @Param("end") Long end);

    List<TOrder> queryByRangeBetweenAnd(@Param("start") Long start, @Param("end") Long end);
}
