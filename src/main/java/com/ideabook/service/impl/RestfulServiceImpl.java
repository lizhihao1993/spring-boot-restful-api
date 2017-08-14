package com.ideabook.service.impl;

import com.ideabook.dao.CityRepo;
import com.ideabook.entity.City;
import com.ideabook.service.RestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lzh
 * @Description:
 * @Date: Created in 2017/8/7 14:46
 */
@Service
public class RestfulServiceImpl implements RestfulService {
    private CityRepo cityRepo;
    @Autowired
    public RestfulServiceImpl(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    @Override
    public City saveCity(City city) {
        return cityRepo.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepo.delete(id);
    }

    @Override
    public Integer updateCity(Long id, String name) {
        return cityRepo.updateCityName(name,System.currentTimeMillis(),id);
    }

    @Override
    public City getCity(Long id) {
        return cityRepo.findOne(id);
    }

    @Override
    public List<City> listCity() {
        return cityRepo.findAll();
    }

    @Override
    public Page<City> listCity(Integer pages, Integer size) {
        Pageable page = new PageRequest(pages,size);
        return cityRepo.findAll(page);
    }
}
