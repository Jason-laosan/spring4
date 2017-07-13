package com.test.service.impl;

import com.base.BaseService;
import com.entity.City;
import com.test.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jinkai on 12/07/2017.
 */
@Service
public class CityServiceImpl  extends BaseService implements CityService {



    public List<City> getCityList() {
        return  baseDao.selectList("CityMapper.getCityList");
    }
}
