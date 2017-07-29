package com.hiper2d.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hiper2d.util.Packages;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = {Packages.REPOSIORIES})
@EnableTransactionManagement
public class JpaConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource ds = new HikariDataSource();
		//HikariConfig config = new HikariConfig("src/main/resources/db.properties");
		ds.setJdbcUrl("jdbc:mysql://rds-mysql-assessment.ckld9drpn0yb.eu-west-1.rds.amazonaws.com:3306/airlines_sandbox");
		ds.setUsername("a_zelenovsky");
		ds.setPassword("zelenovsky_260739");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(Packages.ENTITIES);
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaProperties(getJpaProperties());
		return factory;
	}
	
	private Properties getJpaProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.show_sql", "true");
		return prop;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactory().getObject());
		return manager;
	}
}
