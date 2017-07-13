package com.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jinkai on 12/07/2017.
 */
public class BaseService {
    @Autowired
    protected BaseDao baseDao;

}
