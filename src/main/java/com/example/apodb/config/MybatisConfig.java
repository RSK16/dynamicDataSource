package com.example.apodb.config;

/**
 * @program: apodb
 * @description: ${description}
 * @author: zhaokang
 * @create: 2018-09-08 12:07
 **/

import com.google.common.collect.Maps;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static com.example.apodb.config.DataSources.*;

@Configuration
@MapperScan(basePackages = {"com.example.apodb.dao"})
// 这里需要替换为实际的路径
public class MybatisConfig {

    //数据源1
    @Bean(name = MASTER_DB)
    @ConfigurationProperties(prefix = "spring.datasource") // application.properteis中对应属性的前缀
    public DataSource dataSourceMaster() {
        return DataSourceBuilder.create().build();
    }

    //数据源2
    @Bean(name = SLAVE_DB)
    @ConfigurationProperties(prefix = "spring.second-datasource") // application.properteis中对应属性的前缀
    public DataSource dataSourceSlave() {
        return DataSourceBuilder.create().build();
    }

    /** * 动态数据源 */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSourceMaster());
        //配置多数据源
        Map<Object, Object> dsMap = Maps.newHashMap();
        dsMap.put(MASTER_DB, dataSourceMaster());
        dsMap.put(SLAVE_DB, dataSourceSlave());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}

