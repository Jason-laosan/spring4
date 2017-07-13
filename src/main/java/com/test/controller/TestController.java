package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinkai on 11/07/2017.
 */
@Controller
public class TestController {

    @Autowired
    private CityService cityService;

    @GetMapping(name = "/test")

    public @ResponseBody  String test() {
        return JSON.toJSONString(cityService.getCityList());
    }

}
