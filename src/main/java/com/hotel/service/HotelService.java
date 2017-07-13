package com.hotel.service;

import com.base.PageList;
import com.entity.Hotel;

/**
 * Created by jinkai on 12/07/2017.
 */
public interface HotelService {
    public PageList<Hotel> getPageHotel(Integer toPage,Integer pageSize);
}
