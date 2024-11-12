package dev.rutgerk.authentication_service.application;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "dev.rutgerk.authentication_service.repository",
    entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
public class DatabaseConfig {

  @Autowired
  private Environment env;
  private LocalContainerEntityManagerFactoryBean entityManagerFactory;


  @Bean
  public LocalContainerEntityManagerFactoryBean entityManager() {
    entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactory.setDataSource(dataSource());
    entityManagerFactory
        .setPackagesToScan(new String[] {"dev.rutgerk.authentication_service.model"});

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

    return entityManagerFactory;
  }

  @Bean
  public DataSource dataSource() {

    final HikariDataSource ds = new HikariDataSource();
    try {
      ds.setMaximumPoolSize(Integer.parseInt(env.getProperty("spring.datasource.max-poolsize")));
    } catch (NumberFormatException e) {
      ds.setMaximumPoolSize(10);
    }
    ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
    ds.setUsername(env.getProperty("spring.datasource.username"));
    ds.setPassword(env.getProperty("spring.datasource.password"));
    return ds;

  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManager().getObject());
    return transactionManager;
  }

  public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
    return this.entityManagerFactory;
  }

}
