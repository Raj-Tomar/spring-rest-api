package com.raj.app.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:hibernate.properties" })
public class HibernateConfiguration {

	@Autowired
	private Environment environment;

	// Hibernate Properties Configuration Start
	
	// Reading file from Environment Path variable
	/*
	@Bean(name="propertyConfigurer")
	public static PropertyPlaceholderConfigurer properties(){
		PropertyUtilConfigurer ppc = new PropertyUtilConfigurer();
		Resource[] resources = new ClassPathResource[ ]
					{ new ClassPathResource( "application.properties" ) };
			ppc.setLocations( resources );
		ppc.setFileName("application.properties");
		ppc.setIgnoreUnresolvablePlaceholders( true );
		return ppc;
	}
	 */
	
	// Hibernate Properties
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.jdbc.batch_size", environment.getRequiredProperty("hibernate.jdbc.batch_size"));
		properties.put("hibernate.c3p0.max_size", environment.getRequiredProperty("hibernate.c3p0.max_size"));
		properties.put("hibernate.order_updates", environment.getRequiredProperty("hibernate.order_updates"));
		properties.put("hibernate.jdbc.batch_versioned_data", environment.getRequiredProperty("hibernate.jdbc.batch_versioned_data"));
		properties.put("hibernate.temp.use_jdbc_metadata_defaults", environment.getRequiredProperty("hibernate.temp.use_jdbc_metadata_defaults"));
		properties.put("hibernate.connection.autocommit", environment.getRequiredProperty("hibernate.connection.autocommit"));
		
		properties.put("hibernate.connection.release_mode", environment.getRequiredProperty("hibernate.connection.release_mode"));
		return properties;
	}
	
	// Connection Pool Properties
	private Properties getConnectionPoolProperties() {
		Properties properties = new Properties();
		properties.put("initialPoolSize", environment.getRequiredProperty("hibernate.c3p0.initialPoolSize"));
		properties.put("minPoolSize", environment.getRequiredProperty("hibernate.c3p0.min_size"));
		properties.put("maxPoolSize", environment.getRequiredProperty("hibernate.c3p0.max_size"));
		properties.put("acquireIncrement", environment.getRequiredProperty("hibernate.c3p0.acquire_increment"));
		properties.put("idleConnectionTestPeriod", environment.getRequiredProperty("hibernate.c3p0.idle_test_period"));
		properties.put("loginTimeout", environment.getRequiredProperty("hibernate.c3p0.timeout"));
		properties.put("maxIdleTimeExcessConnections", environment.getRequiredProperty("hibernate.c3p0.maxIdleTimeExcessConnections"));
		return properties;
	}
	
	// Hibernate Properties Configuration End

	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Multiple Database Configuration Start


	// DataSource Configuration Start
	@Bean(name = "dataSource")
	public DataSource getDataSource() throws Exception {
		/*
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.connection.driver_class"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.connection.url.test"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.connection.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.connection.password"));
		dataSource.setConnectionProperties(getConnectionPoolProperties());
		return dataSource;
		*/

		// Connection Pooling
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty("jdbc.connection.driver_class"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.connection.url.test"));
		dataSource.setUser(environment.getRequiredProperty("jdbc.connection.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.connection.password"));
		/*
		dataSource.setAcquireIncrement(5);
		dataSource.setIdleConnectionTestPeriod(60);
		dataSource.setMaxPoolSize(100);
		dataSource.setMaxStatements(50);
		dataSource.setMinPoolSize(10);
		*/
		//dataSource.setProperties(getConnectionPoolProperties());
		return dataSource;
		
	}

	@Bean(name = "dataSourceWorld")
	public DataSource getDataSourceWorld() throws Exception {
		/*
		DriverManagerDataSource dataSourceWorld = new DriverManagerDataSource();
		dataSourceWorld.setDriverClassName(environment.getRequiredProperty("jdbc.connection.driver_class"));
		dataSourceWorld.setUrl(environment.getRequiredProperty("jdbc.connection.url.world"));
		dataSourceWorld.setUsername(environment.getRequiredProperty("jdbc.connection.username"));
		dataSourceWorld.setPassword(environment.getRequiredProperty("jdbc.connection.password"));
		dataSourceWorld.setConnectionProperties(getConnectionPoolProperties());
		return dataSourceWorld;
		*/
		
		// Connection Pooling
		ComboPooledDataSource dataSourceWorld = new ComboPooledDataSource();
		dataSourceWorld.setDriverClass(environment.getRequiredProperty("jdbc.connection.driver_class"));
		dataSourceWorld.setJdbcUrl(environment.getRequiredProperty("jdbc.connection.url.world"));
		dataSourceWorld.setUser(environment.getRequiredProperty("jdbc.connection.username"));
		dataSourceWorld.setPassword(environment.getRequiredProperty("jdbc.connection.password"));
		//dataSourceWorld.setProperties(getConnectionPoolProperties());
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


	// Multiple Database Configuration End


	/*
	@Bean(name = "dataSource")
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
	}

	 */
}
