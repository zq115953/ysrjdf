package com.nectar.myblog.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Describe: Hikaricp 连接池
 */
@Configuration
public class DbConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource(@Autowired Environment environment){

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(environment.getProperty("zq.db.driverClassName"));
        dataSource.setJdbcUrl(environment.getProperty("zq.db.url"));
        dataSource.setUsername(environment.getProperty("zq.db.username"));
        dataSource.setPassword(environment.getProperty("zq.db.password"));

        return dataSource;
    }

}
