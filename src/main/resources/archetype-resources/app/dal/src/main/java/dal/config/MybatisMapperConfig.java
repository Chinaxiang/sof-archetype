#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * coder4j.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package ${package}.dal.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 
 * @author yanxiang.huang 2017-07-26 10:38:48
 */
@Configuration
@Order(2)
public class MybatisMapperConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("${package}.dal.dao");
        return mapperScannerConfigurer;
    }
}
