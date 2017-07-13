package com.hotel.service.impl;

import com.base.BaseService;
import com.base.PageList;
import com.entity.Hotel;
import com.hotel.service.HotelService;
import org.springframework.stereotype.Service;

/**
 * Created by jinkai on 12/07/2017.
 */
@Service
public class HotelServiceImpl extends BaseService implements HotelService {
    public PageList<Hotel> getPageHotel(Integer toPage,Integer pageSize) {
        return baseDao.queryForPageList("HotelMapper.getPageHotel", null, toPage, pageSize);
    }
}
