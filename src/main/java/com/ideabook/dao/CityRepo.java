package com.ideabook.dao;

import com.ideabook.entity.City;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: lzh
 * @Description:
 * @Date: Created in 2017/8/7 14:57
 */
public interface CityRepo extends JpaRepository<City,Long> {

    //利用原生的SQL进行修改操作
    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update City set name=:name, createDate=:createDate where id=:id")
    Integer updateCityName(@Param("name") String name, @Param("createDate") Long createDate, @Param("id") Long id);
}
