package com.gomefinance.hl.security;

import com.gomefinance.hl.security.common.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@SpringBootApplication
//@EnableWebMvc  //不需要加此注解，否则会出现500 servlet解析jsp页面失败
// 这里要特别注意，不要把BaseMapper放到 basePackage 中，也就是不能同其他Mapper一样被扫描到。
@MapperScan(basePackages = "com.gomefinance.hl.security.*" , markerInterface = BaseMapper.class)
@ImportResource(value = {"classpath:spring-framework-security_Remember.xml"})
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String args[]) throws Exception {

        log.info(" spring-web-security 项目启动开始，spring-boot初始化");

        SpringApplication.run(Application.class, "args");

        log.info(" spring-web-security 项目启动完成，spring-boot结束");

    }



    /**
     * druid 数据源
     *
     * @return
     */
    @Bean(name = "dataSource")
    @Qualifier(value = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }


}