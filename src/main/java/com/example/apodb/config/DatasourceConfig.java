package com.example.apodb.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @program: apodb
 * @description: ${定义数据库实体类并配置为多数据源的形式 ，这里不要忽略了通过 MapperScan 指定需要扫描的mybatis的接口类}
 * @author: zhaokang
 * @create: 2018-09-08 11:01
 **/
@Configuration
public class DatasourceConfig {
    //destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
    @Bean( name = DataSources.MASTER_DB)
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

     @Bean(name = DataSources.SLAVE_DB)
     @ConfigurationProperties(prefix = "spring.second-datasource")
     public DataSource dataSourceSlave() {
         return DataSourceBuilder.create().type(DruidDataSource.class).build();
     }

}
