package co.net.parking.dad.multidatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(
	exclude = {
			DataSourceAutoConfiguration.class,
			HibernateJpaAutoConfiguration.class,
			DataSourceTransactionManagerAutoConfiguration.class
	}
)
public class MultiDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDatabaseApplication.class, args);
	}

}
