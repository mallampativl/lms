package com.lms.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.lms.utill.Constants;

@Configuration
@ComponentScan("com.lms")
@PropertySources({
        @PropertySource("classpath:properties/DataBase.properties"),
        @PropertySource("classpath:properties/Queries.properties")
})
public class DataSourceConfig {
	
	@Autowired
	Environment environment;
	
	@Bean("dbConfig")
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		 messageSource.setBasename("classpath:properties/Queries");
		return messageSource;
	}
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(Constants.URL));
		driverManagerDataSource.setUsername(environment.getProperty(Constants.USER));
		driverManagerDataSource.setDriverClassName(environment.getProperty(Constants.DRIVER));
		driverManagerDataSource.setPassword(environment.getProperty(Constants.PASSWORD));
		return driverManagerDataSource;
	}
	
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }
	
	
	

}
