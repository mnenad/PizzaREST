package com.pizza.backend.atb;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudDataSourceConfig extends AbstractCloudConfig {

    @Bean
    public DataSource dataSource() {
    	System.out.println("---Cloud profile for data source running---");
        return connectionFactory().dataSource();
    }

}
