package com.vip.points.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;

@Configuration
@PropertySource({"classpath:database.properties"})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.vip.points.repository")
@ComponentScan(basePackages = "com.vip.points")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();

        try {
            cpds.setDriverClass(Objects.requireNonNull(environment.getProperty("postgresql.driver")));
            cpds.setJdbcUrl(Objects.requireNonNull(environment.getProperty("postgresql.url")));
            cpds.setUser(Objects.requireNonNull(environment.getProperty("postgresql.user")));
            cpds.setPassword(Objects.requireNonNull(environment.getProperty("postgresql.password")));

            cpds.setMinPoolSize(Integer.parseInt(Objects.requireNonNull(environment
                    .getProperty("hibernate.c3p0.min_size"))));
            cpds.setAcquireIncrement(Integer.parseInt(Objects.requireNonNull(environment
                    .getProperty("hibernate.c3p0.acquire_increment"))));
            cpds.setMaxPoolSize(Integer.parseInt(Objects.requireNonNull(environment
                    .getProperty("hibernate.c3p0.max_size"))));

        } catch (PropertyVetoException ex) {
            return null;
        }
        return cpds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.vip.points");
        factory.setDataSource(dataSource());
        return factory;
    }

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManagerBean(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
