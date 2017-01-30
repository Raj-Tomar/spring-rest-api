package com.raj.app.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.raj.beans","com.raj.controller","com.raj.service", 
								"com.raj.serviceImpl","com.raj.dao","com.raj.daoImpl"})
@PropertySource(value = { "classpath:hibernate.properties" })
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
    private Environment environment;
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    /*
    
     @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        return bean;
    }
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
     
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }
 
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }
    */
	
	/*@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.connection.driver_class"));
	    dataSource.setUrl(environment.getRequiredProperty("jdbc.connection.url.test"));
	    dataSource.setUsername(environment.getRequiredProperty("jdbc.connection.username"));
	    dataSource.setPassword(environment.getRequiredProperty("jdbc.connection.password"));
	    return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	 
	    
	    sessionBuilder.addAnnotatedClasses(CityBean.class);
	    sessionBuilder.addAnnotatedClasses(CountryBean.class);
	    sessionBuilder.addAnnotatedClasses(DepartmentBean.class);
	    sessionBuilder.addAnnotatedClasses(DeptContactDetail.class);
	    sessionBuilder.addAnnotatedClasses(EmployeeBean.class);
	    
	   
	    //sessionBuilder.addAnnotatedClasses(CityBean.class, CountryBean.class);
	    sessionBuilder.scanPackages("com.raj.beans");
	    
	    //sessionBuilder.setProperty("hibernate.show_sql", "true");
	    
	    sessionBuilder.addProperties(getHibernateProperties());
	 
	    return sessionBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	    return properties;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}*/
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // Multiple Database Configuration Start
    
    // DataSource Configuration Start
    @Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.connection.driver_class"));
	    dataSource.setUrl(environment.getRequiredProperty("jdbc.connection.url.test"));
	    dataSource.setUsername(environment.getRequiredProperty("jdbc.connection.username"));
	    dataSource.setPassword(environment.getRequiredProperty("jdbc.connection.password"));
	    return dataSource;
	}
    
    @Bean(name = "dataSourceWorld")
	public DataSource getDataSourceWorld() {
		BasicDataSource dataSourceWorld = new BasicDataSource();
		dataSourceWorld.setDriverClassName(environment.getRequiredProperty("jdbc.connection.driver_class"));
		dataSourceWorld.setUrl(environment.getRequiredProperty("jdbc.connection.url.world"));
		dataSourceWorld.setUsername(environment.getRequiredProperty("jdbc.connection.username"));
		dataSourceWorld.setPassword(environment.getRequiredProperty("jdbc.connection.password"));
	    return dataSourceWorld;
	}
    // DataSource Configuration End
    
    // SessionFactory Configuration Start
    
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.scanPackages("com.raj.beans");
	    sessionBuilder.addProperties(getHibernateProperties());
	    return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "sessionFactoryWorld")
	public SessionFactory getSessionFactoryWorld(DataSource dataSourceWorld) {
	    LocalSessionFactoryBuilder sessionBuilderWorld = new LocalSessionFactoryBuilder(dataSourceWorld);
	    sessionBuilderWorld.scanPackages("com.raj.beans");
	    sessionBuilderWorld.addProperties(getHibernateProperties());
	    return sessionBuilderWorld.buildSessionFactory();
	}
	
	// SessionFactory Configuration End
	
	// TransactionManager Configuration Start
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);
		return transactionManager;
	}
    
	@Autowired
	@Bean(name = "transactionManagerWorld")
	public HibernateTransactionManager getTransactionManagerWorld(
			SessionFactory sessionFactoryWorld) {
		HibernateTransactionManager transactionManagerWorld = new HibernateTransactionManager(
				sessionFactoryWorld);
		return transactionManagerWorld;
	}
	// TransactionManager Configuration End
	
	// Hibernate Properties Configuration Start
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	    return properties;
	}
	// Hibernate Properties Configuration End
	
	
    // Multiple Database Configuration End
    
    
    
}
