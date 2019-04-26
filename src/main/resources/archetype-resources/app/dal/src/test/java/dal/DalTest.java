#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * QUANSHI.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package ${package}.dal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author yanxiang.huang 2017-07-26 10:45:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dal-beans.xml"})
public class DalTest implements InitializingBean
{
    
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void afterPropertiesSet() throws Exception
    {
        logger.info("dal test init.");
    }
    
    @Test
    public void justTest() {
        logger.info("just test.");
    }

}
