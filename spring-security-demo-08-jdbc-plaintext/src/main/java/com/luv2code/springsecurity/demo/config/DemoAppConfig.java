package com.luv2code.springsecurity.demo.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties") // hold the config file in resources
public class DemoAppConfig{

	// set up variable to hold the properties
	@Autowired
	private Environment env;
	
	// set up a logger for diagnostic
	private Logger logger = Logger.getLogger(getClass().getName());

	
	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}	
	
	//define a bean for security data source
	
	@Bean
	public DataSource securityDataSource() {
		
		// create connection pool
		//ComboPooledDataSource securityDataSource = new ComboPooledDataSource(); //<-- for c3p0
		/*
		// set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver")); // in brackets reads info from config file resources/persistence-mysql.properties
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// log the connection props
		logger.info(">>>>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>>>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool props		
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;*/
		
		/* HIKARICP Config */
		
		HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName(env.getProperty("jdbc.driver"));
	    hikariConfig.setJdbcUrl(env.getProperty("jdbc.url")); 
	    hikariConfig.setUsername(env.getProperty("jdbc.user"));
	    hikariConfig.setPassword(env.getProperty("jdbc.password"));
	    
	    // log the connection props
 		logger.info(">>>>> jdbc.url=" + env.getProperty("jdbc.url"));
 		logger.info(">>>>> jdbc.user=" + env.getProperty("jdbc.user"));

	    hikariConfig.setMaximumPoolSize(getIntProperty("connection.pool.maxPoolSize"));
	    hikariConfig.setPoolName("springHikariCP");

	    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
		
	}
	
	// create a helper method
	// read environment property and convert to int
	private int getIntProperty (String propName) {
		
		String propVal = env.getProperty(propName);
		
		// convert string to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
	
	
	
	
	
}
