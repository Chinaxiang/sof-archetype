#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * QUANSHI.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package ${package}.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author yanxiang.huang 2017-07-26 10:29:02
 */
@Controller
public class IndexController
{

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
}
