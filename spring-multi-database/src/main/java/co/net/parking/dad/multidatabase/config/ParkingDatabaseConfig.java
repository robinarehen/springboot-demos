package co.net.parking.dad.multidatabase.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = "co.net.parking.dad.multidatabase.parking.repository",
		entityManagerFactoryRef = "parkingEntityManagerFactory",
		transactionManagerRef = "parkingTransactionManager"
)
public class ParkingDatabaseConfig {

    @Autowired
    private Environment env;
    
	@Bean
	@ConfigurationProperties(prefix = "datasource.parking")
	public DataSourceProperties parkingDataSourceProperties() {
		return new DataSourceProperties();
	}
	
    @Bean
    public DataSource parkingDataSource() {
         DataSourceProperties dataSourceProperties = parkingDataSourceProperties();
         
         return DataSourceBuilder.create()
        .driverClassName(dataSourceProperties.getDriverClassName())
        .url(dataSourceProperties.getUrl())
        .username(dataSourceProperties.getUsername())
        .password(dataSourceProperties.getPassword())
        .build();
    }
    
    @Bean
    public PlatformTransactionManager parkingTransactionManager()
    {
        EntityManagerFactory factory = parkingEntityManagerFactory().getObject();
        
        return new JpaTransactionManager(factory);
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean parkingEntityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        
        factory.setDataSource(parkingDataSource());
        
        factory.setPackagesToScan(new String[]{"co.net.parking.dad.multidatabase.parking.model"});
        
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
     
        Properties jpaProperties = new Properties();
        
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        
        jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        
        factory.setJpaProperties(jpaProperties);
     
        return factory;
    }
}