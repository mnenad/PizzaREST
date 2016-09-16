package com.pizza.backend.atb;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!cloud")
public class LocalDataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
