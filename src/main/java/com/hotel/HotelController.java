package com.hotel;

import com.alibaba.fastjson.JSON;
import com.base.CommonJsonResult;
import com.base.PageList;
import com.entity.Hotel;
import com.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinkai on 12/07/2017.
 */
@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel")
    public CommonJsonResult getHotel(@RequestParam(required = false,defaultValue = ""+1) Integer pageIndex,
                                     @RequestParam(required = false,defaultValue = ""+10) Integer pageSize) {
        CommonJsonResult result = new CommonJsonResult();
        PageList<Hotel> pageList =  hotelService.getPageHotel(Integer.parseInt(pageIndex.toString()),Integer.parseInt(pageSize.toString()));
        result.setPaging(pageList.getTotalCount(),pageList.getPageSize(),pageList.getNextPage(),pageList.hashNextPage());
        result.setResultList(pageList.getRecords());
        return  result;
    }
}
