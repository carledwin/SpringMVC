package com.wordpress.carledwinj.config.db;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.wordpress.carledwinj.repository")
public class ConfigurationDB {

	/*PROPERTIES HSQLDB*/
	private static final String PROPERTY_NAME_DATABASE_DRIVER_HSQLDB = "org.hsqldb.jdbcDriver";
	private static final String PROPERTY_NAME_DATABASE_MEMO_URL_HSQLDB = "jdbc:hsqldb:mem:restaurantedb";
	private static final String PROPERTY_NAME_DATABASE_USERNAME_HSQLDB = "sa";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD_HSQLDB = "sa";
	private static final Object DIALECT_HSQLDB = "org.hibernate.dialect.HSQLDialect";
	
	/*PROPERTIES MYSQL*/
	private static final String PROPERTY_NAME_DATABASE_DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private static final String PROPERTY_NAME_DATABASE_LOCAL_URL_MYSQL = "jdbc:mysql://localhost:3306/restaurantedb";
	private static final String PROPERTY_NAME_DATABASE_USERNAME_MYSQL = "root";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD_MYSQL = "sa";
	private static final Object DIALECT_MYSQL = "org.hibernate.dialect.MySQL5InnoDBDialect";
		
	private static final Object HBM2DDL_CREATE = "create";
	private static final Object HBM2DDL_UPDATE = "update";
	private static final Object FALSE = "false";
	private static final Object TRUE = "true";
	
	@Bean
	public DataSource dataSource() throws IllegalStateException, PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		/*Configuracao para HSQLDB*/
		getDataSourceHsqldb(dataSource);
		
		/*Configuracao para MYSQL*/
		//getDataSourceMysql(dataSource);
		
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.wordpress.carledwinj.model");
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
		
		/*Configuracao para HSQLDB*/
		getPropertiesHsqldb(entityManagerFactoryBean);
		
		/*Configuracao para MYSQL*/
		//getPropertiesMysql(entityManagerFactoryBean);
		
		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	/**
	 * Captura o dataSource utilizando banco HSQLDB
	 * @param dataSource
	 * @throws PropertyVetoException
	 */
	private void getDataSourceHsqldb(ComboPooledDataSource dataSource) throws PropertyVetoException {
		dataSource.setDriverClass(PROPERTY_NAME_DATABASE_DRIVER_HSQLDB);
		dataSource.setJdbcUrl(PROPERTY_NAME_DATABASE_MEMO_URL_HSQLDB);
		dataSource.setUser(PROPERTY_NAME_DATABASE_USERNAME_HSQLDB);
		dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD_HSQLDB);
	}

	/**
	 * Captura os properties de configuracao utilizados para o banco HSQLDB
	 * @param entityManagerFactoryBean
	 */
	private void getPropertiesHsqldb(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", DIALECT_HSQLDB);
		jpaProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_CREATE);
		jpaProperties.put("show_sql", TRUE);
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
	}
	
	/**
	 * Captura o dataSource utilizando banco HSQLDB 
	 * @param dataSource
	 * @throws PropertyVetoException
	 */
	private void getDataSourceMysql(ComboPooledDataSource dataSource) throws PropertyVetoException {
		dataSource.setDriverClass(PROPERTY_NAME_DATABASE_DRIVER_MYSQL);
		dataSource.setJdbcUrl(PROPERTY_NAME_DATABASE_LOCAL_URL_MYSQL);
		dataSource.setUser(PROPERTY_NAME_DATABASE_USERNAME_MYSQL);
		dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD_MYSQL);
	}
	
	/**
	 * Captura os properties de configuracao utilizados para o banco HSQLDB 
	 * @param entityManagerFactoryBean
	 */
	private void getPropertiesMysql(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", DIALECT_MYSQL);
		jpaProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_CREATE);
		jpaProperties.put("show_sql", TRUE);
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
	}
}
