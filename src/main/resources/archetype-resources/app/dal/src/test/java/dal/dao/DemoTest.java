#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * QUANSHI.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package ${package}.dal.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import ${package}.dal.DalTest;
import ${package}.dal.entity.Demo;

/**
 * 
 * @author yanxiang.huang 2017-07-26 10:47:14
 */
public class DemoTest extends DalTest
{

    @Resource
    private DemoMapper mapper;
    
    @Test
    public void insertTest() {
        Demo o = new Demo();
        Date now = new Date();
        o.setName( "demo name" );
        o.setAge( 18 );
        o.setCreateTime( now );
        o.setUpdateTime( now );
        int res = mapper.insert( o );
        Assert.assertEquals( 1, res );
        Assert.assertNotNull( o.getId() );
    }
}
