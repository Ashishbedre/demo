package com.example.demo.H2.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
@Configuration
@Profile("repo")
@EnableJpaRepositories(basePackages = "com.example.demo.H2.repo",
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager")
public class H2Config {

    @Bean(name = "h2DataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:D:/data/controller_client_internal_details");
        dataSource.setUsername("sa");
        dataSource.setPassword("password");
        return dataSource;
    }

}







//@Configuration
//@EnableJpaRepositories(basePackages = "com.example.demo.H2.repo",
//        entityManagerFactoryRef = "H2EntityManagerFactory",
//        transactionManagerRef = "H2TransactionManager")
//@EnableTransactionManagement
//public class H2Config {
//    @Autowired
//    private Environment environment;
//
//    @Primary
//    @Bean(name = "h2DataSource")
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getProperty("spring.h2.datasource.driverClassName"));
//        dataSource.setUrl(environment.getProperty("spring.h2.datasource.url"));
//        dataSource.setUsername(environment.getProperty("spring.h2.datasource.username"));
//        dataSource.setPassword(environment.getProperty("spring.h2.datasource.password"));
//        return dataSource;
//    }
//
//    @Bean(name = "H2EntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(adapter);
//        Map<String,String> props= new HashMap<>();
//        props.put("spring.h2.console.enabled","true");
//        bean.set
//        em.setPackagesToScan("com.example.demo.entites");
//        em.setPersistenceUnitName("mysql");
//
//        // Additional JPA properties can be configured here
//
//        return em;
//    }
//
//    @Bean(name = "H2TransactionManager")
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(entityManagerFactory().Bean.getObject());
//        return manager;
//    }
//}
