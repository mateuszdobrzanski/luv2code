package com.luv2code.springdemo.config;

import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.luv2code.springdemo")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class DemoAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public DataSource myDataSource() {
		
		// create connection pool
		HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName(env.getProperty("jdbc.driver"));
	    hikariConfig.setJdbcUrl(env.getProperty("jdbc.url")); 
	    hikariConfig.setUsername(env.getProperty("jdbc.user"));
	    hikariConfig.setPassword(env.getProperty("jdbc.password"));
	    
	    // log the connection props
 		logger.info(">>>>> jdbc.url=" + env.getProperty("jdbc.url"));
 		logger.info(">>>>> jdbc.user=" + env.getProperty("jdbc.user"));
 		
 		
 		// set connection pool props
	    hikariConfig.setMaximumPoolSize(getIntProperty("connection.pool.initialPoolSize"));
	    hikariConfig.setMaximumPoolSize(getIntProperty("connection.pool.minPoolSize"));
	    hikariConfig.setMaximumPoolSize(getIntProperty("connection.pool.maxPoolSize"));
	    hikariConfig.setMaximumPoolSize(getIntProperty("connection.pool.maxIdleTime"));

	    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
	    
	    hikariConfig.addDataSourceProperty("characterEncoding","utf-8");
	    hikariConfig.addDataSourceProperty("CharSet","utf-8");
	    hikariConfig.addDataSourceProperty("useUnicode","true");
   

	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;	
		
	}
	
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		props.setProperty("hibernate.useUnicode", "true");
		props.setProperty("hibernate.characterEncoding", "UTF-8");
		props.setProperty("hibernate.charSet", "UTF-8");
		
		return props;				
	}

	
	// need a helper method 
	// read environment property and convert to int
	
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		// now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
	
}









