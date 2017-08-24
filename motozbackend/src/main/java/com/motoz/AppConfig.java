package com.motoz;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

/**
 * Hello world!
 *
 */
@Configuration
public class AppConfig 
{
    @Bean(name = "dataSource")
    public DataSource getDataSource()
    {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	return dataSource;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(javax.sql.DataSource dataSource)
    {
    	LocalSessionFactoryBuilder sessionBuilder = 
    		new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.scanPackages("com.motoz.model");
    	sessionBuilder.setProperty("hibernate.show_sql", "true");
    	sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "update");
    	return sessionBuilder.buildSessionFactory();
    }
}

