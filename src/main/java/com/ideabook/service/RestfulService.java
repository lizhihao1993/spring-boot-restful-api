package com.ideabook.service;


import com.ideabook.entity.City;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: lzh
 * @Description:
 * @Date: Created in 2017/8/7 14:42
 */
public interface RestfulService {
    City saveCity(City city);
    void deleteCity(Long id);
    Integer updateCity(Long id,String name);
    City getCity(Long id);
    List<City> listCity();

    /**
     * 分页list
     * @param pages 最小值：0
     * @param size  最小值：1
     * @return 分页
     */
    Page<City> listCity(Integer pages,Integer size);
}
